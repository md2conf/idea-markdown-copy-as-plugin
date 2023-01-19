package com.github.qwazer.ideamarkdowncopyas.action.handler;

import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.jira.converter.JiraConverterExtension;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.List;

public class MarkdownToJiraFormattedHandler extends AbstractMarkdownHandler {

    public MarkdownToJiraFormattedHandler() {
        super(new MutableDataSet()
                .set(Parser.EXTENSIONS, List.of(
                        TablesExtension.create(),
                        StrikethroughExtension.create(),
                        JiraConverterExtension.create()
                )));
    }
}
