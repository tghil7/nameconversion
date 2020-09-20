module testFX {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.web;
	
	
	opens application to javafx.graphics, javafx.fxml;
}
