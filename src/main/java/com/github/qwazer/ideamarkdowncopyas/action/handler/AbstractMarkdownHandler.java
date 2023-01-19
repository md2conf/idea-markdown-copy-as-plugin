package com.github.qwazer.ideamarkdowncopyas.action.handler;

import com.intellij.codeInsight.editorActions.TextBlockTransferable;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.util.ui.TextTransferable;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.IRender;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collections;

public abstract class AbstractMarkdownHandler extends EditorActionHandler {

    final Parser parser;
    final IRender renderer;

    public AbstractMarkdownHandler(DataHolder options) {
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
        TextTransferable contents= new TextTransferable(res);
        CopyPasteManager.getInstance().setContents(contents);
    }
}
