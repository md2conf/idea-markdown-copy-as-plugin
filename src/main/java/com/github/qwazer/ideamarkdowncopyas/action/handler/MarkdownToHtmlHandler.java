package com.github.qwazer.ideamarkdowncopyas.action.handler;

import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.emoji.EmojiImageType;
import com.vladsch.flexmark.ext.emoji.EmojiShortcutType;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.List;

public class MarkdownToHtmlHandler extends AbstractMarkdownHandler {
    public MarkdownToHtmlHandler() {
        super(new MutableDataSet().set(Parser.EXTENSIONS, List.of(
                                          AutolinkExtension.create(),
                                          EmojiExtension.create(),
                                          StrikethroughExtension.create(),
                                          TaskListExtension.create(),
                                          TablesExtension.create()
                                  ))
                                  // set GitHub table parsing options
                                  .set(TablesExtension.WITH_CAPTION, false)
                                  .set(TablesExtension.COLUMN_SPANS, false)
                                  .set(TablesExtension.MIN_HEADER_ROWS, 1)
                                  .set(TablesExtension.MAX_HEADER_ROWS, 1)
                                  .set(TablesExtension.APPEND_MISSING_COLUMNS, true)
                                  .set(TablesExtension.DISCARD_EXTRA_COLUMNS, true)
                                  .set(TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH, true)

                                  // setup emoji shortcut options
                                  // uncomment and change to your image directory for emoji images if you have it setup
                                  //.set(EmojiExtension.ROOT_IMAGE_PATH, emojiInstallDirectory())
                                  .set(EmojiExtension.USE_SHORTCUT_TYPE, EmojiShortcutType.GITHUB)
                                  .set(EmojiExtension.USE_IMAGE_TYPE, EmojiImageType.IMAGE_ONLY)
        );
    }
}
