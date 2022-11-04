package com.github.qwazer.ideamarkdowncopyas.action;

import com.github.qwazer.ideamarkdowncopyas.action.handler.MarkdownToJiraFormattedHandler;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorAction;
import com.intellij.openapi.editor.ex.util.EditorUtil;
import org.jetbrains.annotations.NotNull;

public class MarkdownCopyAsJIraFormattedAction extends EditorAction {

    protected MarkdownCopyAsJIraFormattedAction() {
        super(new MarkdownToJiraFormattedHandler());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        e.getPresentation().setVisible(e.getPresentation().isVisible() && !EditorUtil.contextMenuInvokedOutsideOfSelection(e));
    }

    @Override
    public void update(Editor editor, Presentation presentation, DataContext dataContext) {
        super.update(editor, presentation, dataContext);
        presentation.setVisible(editor.getSelectionModel().hasSelection(true));
    }

}
