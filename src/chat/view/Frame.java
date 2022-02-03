package chat.view;

import chat.controller.Controller;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private Controller app;
	
	private Panel panel;
	
	public Frame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new Panel(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Window");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}

}
