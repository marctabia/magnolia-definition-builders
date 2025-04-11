package com.merkle.oss.magnolia.definition.custom.richtext.toolbarbuilder;


import com.merkle.oss.magnolia.definition.custom.richtext.toolbarbuilder.groupbuilder.AbstractToolbarGroupBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RichTextToolbar implements RichTextToolbarConfig {
	private final List<ToolbarGroup> toolbarGroups;

	public RichTextToolbar(final List<ToolbarGroup> toolbarGroups) {
		this.toolbarGroups = toolbarGroups;
	}

	public static Builder builder() {
		return new Builder();
	}

	public List<ToolbarGroup> getConfig() {
		return toolbarGroups;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof RichTextToolbar that)) {
			return false;
		}
        return Objects.equals(toolbarGroups, that.toolbarGroups);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(toolbarGroups);
	}

	@Override
	public String toString() {
		return "RichTextToolbar{" +
				"toolbarGroups=" + toolbarGroups +
				'}';
	}

	public static final class Builder {
		private final List<AbstractToolbarGroupBuilder<?>> toolsBuilders = new ArrayList<>();

		public Builder add(final AbstractToolbarGroupBuilder<?> groupBuilder) {
			toolsBuilders.add(groupBuilder);
			return this;
		}

		public RichTextToolbar build() {
			return new RichTextToolbar(
					toolsBuilders.stream()
							.map(AbstractToolbarGroupBuilder::build)
							.collect(Collectors.toList())
			);
		}
	}
}
