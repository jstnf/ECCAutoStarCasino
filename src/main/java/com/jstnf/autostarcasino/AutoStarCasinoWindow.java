package com.jstnf.autostarcasino;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class AutoStarCasinoWindow extends JFrame
{
	private JPanel mainPanel;

	private boolean isToggledOn;
	private Gambler g;
	private int milliCount;

	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e)
		{
		}

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AutoStarCasinoWindow frame = new AutoStarCasinoWindow();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public AutoStarCasinoWindow()
	{
		milliCount = 7500;
		isToggledOn = false;
		g = new Gambler();

		setTitle("AutoSC v1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 138);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(new MigLayout("", "[grow]", "[][][grow][]"));

		JLabel credits = new JLabel("AutoStarCasino Tool v1.2 by pokeball92870");
		credits.setForeground(Color.BLACK);
		mainPanel.add(credits, "cell 0 0,alignx center");

		final JLabel status = new JLabel("Status: off");
		mainPanel.add(status, "cell 0 1,alignx center");

		JButton toggleButton = new JButton("Toggle SC Tool");
		toggleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				isToggledOn = !isToggledOn;

				if (isToggledOn)
				{
					status.setText("Status: on");
				}
				else
				{
					status.setText("Status: off");
				}
			}
		});
		mainPanel.add(toggleButton, "flowx,cell 0 2,alignx center");

		final JLabel cycleCounter = new JLabel("7500");
		mainPanel.add(cycleCounter, "cell 0 3,alignx center");

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				loop(g);
			}
		}, 7500, 7500);

		Timer timer2 = new Timer();
		timer2.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				milliCount--;
				if (milliCount < 1)
				{
					milliCount = 7500;
				}

				cycleCounter.setText("Until Cycle: " + (double) (milliCount / 100) / 10 + "s");
			}
		}, 1, 1);
	}

	public void loop(Gambler g)
	{
		if (!isToggledOn)
		{
			return;
		}
		else
		{
			try
			{
				if (isToggledOn)
				{
					g.rightClick();
					Thread.sleep(7000);
				}
				if (isToggledOn)
				{
					g.pressE();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}