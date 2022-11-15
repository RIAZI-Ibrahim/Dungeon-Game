package donjon;

import donjon.framework.Engine;
import donjon.framework.resources.Loader;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Loader.load();
				Engine.init();
				Engine.start();
			}
		});
	}
}