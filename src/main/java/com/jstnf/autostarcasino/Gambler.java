package com.jstnf.autostarcasino;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Gambler
{
	private Robot robot;

	public Gambler()
	{
		try
		{
			robot = new Robot();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void pressE()
	{
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
	}

	public void rightClick()
	{
		try
		{
			robot.mousePress(MouseEvent.BUTTON3_MASK);
			Thread.sleep(100);
			robot.mouseRelease(MouseEvent.BUTTON3_MASK);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}