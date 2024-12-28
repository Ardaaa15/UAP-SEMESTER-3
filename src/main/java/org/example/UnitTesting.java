package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class GuiTest {

    private Gui gui;

    @BeforeEach
    void setUp() {
        gui = new Gui();
        // Initialize any necessary components or mock objects here
    }

    @Test
    void testValidationWithEmptyFields() {
        // Simulate empty fields
        gui.tfno.setText("");
        gui.tfnama.setText("");
        gui.cbtujuan.setSelectedIndex(0);
        gui.buttonGroup1.clearSelection();

        assertFalse(gui.validation(), "Validation should fail with empty fields");
    }

    @Test
    void testValidationWithValidData() {
        // Simulate valid input
        gui.tfno.setText("123");
        gui.tfnama.setText("John Doe");
        gui.cbtujuan.setSelectedIndex(1); // Assuming index 1 is valid
        gui.rbmotor.setSelected(true); // Assuming this is a valid selection

        assertTrue(gui.validation(), "Validation should pass with valid data");
    }

    @Test
    void testIsValidNameWithValidName() {
        assertTrue(gui.isValidName("John Doe"), "Name should be valid");
    }

    @Test
    void testIsValidNameWithInvalidName() {
        assertFalse(gui.isValidName("John123"), "Name should be invalid due to numbers");
        assertFalse(gui.isValidName(""), "Empty name should be invalid");
    }

    @Test
    void testCreateOrUpdateWithValidData() {
        gui.tfno.setText("123");
        gui.tfnama.setText("John Doe");
        gui.rbmotor.setSelected(true);
        gui.cbtujuan.setSelectedItem("Tujuan A");

        // Assuming PengunjungController has a mock or spy to verify interactions
        gui.createOrUpdate(123);

        // Verify that the create method was called with the correct parameters
        // This would require a mock of PengunjungController to verify the interaction
    }

    @Test
    void testCreateOrUpdateWithInvalidName() {
        gui.tfno.setText("123");
        gui.tfnama.setText("John123"); // Invalid name
        gui.rbmotor.setSelected(true);
        gui.cbtujuan.setSelectedItem("Tujuan A");

        // Capture the output of the JOptionPane
        // This would require a way to mock or spy on JOptionPane
        gui.createOrUpdate(123);

        // Verify that the error message was shown
        // This would require a mock of JOptionPane to verify the interaction
    }

    // Additional tests for loadData, delete, and search methods can be added similarly
}