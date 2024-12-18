package com.merkle.oss.magnolia.definition.custom.richtext.toolbarbuilder;

import java.util.List;
import java.util.function.UnaryOperator;


public interface RichTextToolbarConfig {

	List<ToolbarGroup> getConfig();

	static RichTextToolbarConfig build(final UnaryOperator<RichTextToolbar.Builder> function) {
		return () -> function.apply(RichTextToolbar.builder())
				.build()
				.getConfig();
	}
}
