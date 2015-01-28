package dipok.puzzle;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Frame  extends JFrame{
	JTextField [] firstlabels=new JTextField[4],lastLabels=new JTextField[4];
	JButton next=new JButton("Next");
	Select select=new Select();
	Wait wait=new Wait();
	long startTime,endTime;
	public Frame() {
		super("Puzzle");
		setLayout(new BorderLayout());
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(2, 2, 5, 5));
		for (int i = 0; i < firstlabels.length; i++) {
			firstlabels[i]=new JTextField(i+"");
			firstlabels[i].setEditable(false);
			firstlabels[i].setVisible(false);
			panel1.add(firstlabels[i]);
		}
		add(panel1, BorderLayout.NORTH);
		add(next,BorderLayout.CENTER);
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(1, 4, 5, 5));
		for (int i = 0; i < lastLabels.length; i++) {
			lastLabels[i]=new JTextField(i+"");
			lastLabels[i].setEditable(false);
			lastLabels[i].setVisible(false);
			panel2.add(lastLabels[i]);
		}
		add(panel2, BorderLayout.SOUTH);
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < firstlabels.length; i++) {
					firstlabels[i].setVisible(true);
					lastLabels[i].setVisible(false);
				}
				next.setVisible(false);
				endTime=System.currentTimeMillis()+10*1000;
				Thread thread =new Thread(wait);
				thread.start();
			}
		});
	}
	 private class Wait implements Runnable{
		@Override
		public void run() {
			while (System.currentTimeMillis()<(endTime-5*1000)) {
				
			}
			for (int i = 0; i < firstlabels.length; i++) {
				firstlabels[i].setVisible(false);
				lastLabels[i].setVisible(true);
			}
			// TODO Auto-generated method stub
			 Thread thread= new Thread(select);
			 thread.start();
		}
		 
	 } 
	 private class Select implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
				
				while (System.currentTimeMillis()<(endTime)) {
				
				}
				for (int i = 0; i < firstlabels.length; i++) {
					firstlabels[i].setVisible(true);
				}
				next.setVisible(true);
		}
		 
	 }
	
	public static void main(String [] args) {
		Frame frame=new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
	
}
