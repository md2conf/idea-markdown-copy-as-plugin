package com.github.qwazer.ideamarkdowncopyas.action;

import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;

import java.util.Set;

public class ActionUtils {

    public static boolean isMarkdownDocument(AnActionEvent e){
         Project project = e.getRequiredData(CommonDataKeys.PROJECT);
         Document document = e.getRequiredData(PlatformDataKeys.EDITOR).getDocument();
         return isMarkdownPsiFile(project, document);

    }
    private static boolean isMarkdownPsiFile(Project project, Document document) {
        PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
        if (psiFile == null) return false;
        FileViewProvider viewProvider = psiFile.getViewProvider();
        Set<Language> languages = viewProvider.getLanguages();
        return languages.stream()
                        .anyMatch(v->v.getID().equals("Markdown"));
    }
}
