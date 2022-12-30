package com.github.qwazer.ideamarkdowncopyas.action.handler;

import com.intellij.codeInsight.editorActions.TextBlockTransferable;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.ide.CopyPasteManager;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.jira.converter.JiraConverterExtension;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.IRender;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class MarkdownToJiraFormattedHandler extends EditorActionHandler {

    final Parser parser;
    final IRender renderer;

    public MarkdownToJiraFormattedHandler() {
        DataHolder options = new MutableDataSet()
                .set(Parser.EXTENSIONS, List.of(
                        TablesExtension.create(),
                        StrikethroughExtension.create(),
                        JiraConverterExtension.create()
                ));
        this.parser = Parser.builder(options).build();
        this.renderer = HtmlRenderer.builder(options).build();
    }

    @Override
    public void doExecute(@NotNull final Editor editor, @Nullable Caret caret, DataContext dataContext) {
        //no need to convert for empty selection
        if (!editor.getSelectionModel().hasSelection(true)) {
            return;
        }
        String text = editor.getSelectionModel().getSelectedText();
        if (text == null) {
            return;
        }
        Node document = parser.parse(text);
        String res = renderer.render(document);
        TextBlockTransferable contents = new TextBlockTransferable(res, Collections.emptyList(), null);
        CopyPasteManager.getInstance().setContents(contents);
    }
}
