package com.merkle.oss.magnolia.definition.builder.simple;

import com.merkle.oss.magnolia.definition.builder.AbstractFieldDefinitionBuilderTestCase;
import com.vaadin.shared.ui.datefield.DateTimeResolution;

import info.magnolia.ui.field.DateFieldDefinition;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateFieldDefinitionBuilderTest extends AbstractFieldDefinitionBuilderTestCase {
	@Test
	void testBuilder() {
		final DateFieldDefinition definition = super.assertField(new DateFieldDefinitionBuilder(), (name, builder) -> builder.build(name), "2023-04-28")
				.dateFormat("dateFormat")
				.timeFormat("timeFormat")
				.time(true)
				.inISO8061Format(true)
				.resolution(DateTimeResolution.MINUTE)
				.build("date");
		assertEquals("dateFormat", definition.getDateFormat());
		assertEquals("timeFormat", definition.getTimeFormat());
		assertEquals("MINUTE", definition.getResolution());
		assertTrue(definition.isTime());
		assertTrue(definition.isInISO8061Format());

		final DateFieldDefinition emptyDefinition = new DateFieldDefinitionBuilder().build("date");
		assertEquals(Date.class, emptyDefinition.getType());
		assertEquals("yyyy-MM-dd", emptyDefinition.getDateFormat());
		assertEquals("HH:mm", emptyDefinition.getTimeFormat());
		assertNull(emptyDefinition.getResolution());
		assertFalse(emptyDefinition.isTime());
		assertFalse(emptyDefinition.isInISO8061Format());
	}
}
