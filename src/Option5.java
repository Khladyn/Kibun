import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Option5 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(0) no chance", "(1) slight chance", "(2) moderate chance", "(3) high chance"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a ="";	

	public Option5() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("The Epworth Sleepiness Scale (ESS)");
		
		this.setInstructions("\nPlease read each statement and rate your chances of dozing off in these situations"
				+ " even when you are not tired. ");
		
		this.setEBackground("\nThe Epworth Sleepiness Scale is an 8-item questionnaire that asks respondents "
				+ "their usual chances of dozing off or falling asleep while engaged in eight different situations. "
				+ "Most people engage in these activities at least occasionally, although not necessarily every day.");
		
		questions.add("index zero");
		
		questions.add("Sitting and reading");
		
		questions.add("Watching TV");
		
		questions.add("Sitting inactive in a public place (e.g., a theater or a meeting)");
		
		questions.add("As a passenger in a car for an hour without a break");
		
		questions.add("Lying down to rest in the afternoon when circumstances permit");
		
		questions.add("Sitting and talking to someone");
		
		questions.add("Sitting quietly after a lunch without alcohol");
		
		questions.add("In a car, while stopped for a few minutes in traffic");
		
		this.setQuestions(questions);
		
		this.setLikert(likert);		
		
	}
	
	@Override
	public JToggleButton getBut(String s)
	{
		Border nobord = BorderFactory.createEmptyBorder(0,0,0,0);

		JToggleButton jb = new JToggleButton();
		jb.setText(s);
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("Metropolis Medium", Font.PLAIN, 14));
		jb.setBackground(new Color(27,147,111,255));
		jb.setForeground(new Color(255,255,240,255));
		jb.setFocusPainted(false);
		jb.setBorder(nobord);
		jb.setSize(150, 40);
		
		return jb;
	}
	
	@Override
	public void setLikert(String[] likert) {

		this.likert = likert;
		
		int ix = 100;
		int y = 285;
						
		for (Integer i = 0; i < 4; i++) {
			JToggleButton j = getBut(likert[i]);
							
			j.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					j.setCursor(new Cursor(Cursor.HAND_CURSOR));
					j.setBackground(new Color(255,255,240,255));
					j.setForeground(new Color(27,147,111,255));
				}
								
				public void mouseExited(MouseEvent me) {
					j.setForeground(new Color(255,255,240,255));
					j.setBackground(new Color(27,147,111,255));
				}
			});
							
			jbg.add(j);
			j.setActionCommand(likert[i]);
			j.setLocation(ix, y);

			jlp2.add(j, 0);
					
			ix+=150;
		}
}
	
	@Override
	public void next1() {
		brp8.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp8.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				
				if(jbg.getSelection() == null) {
					brp8.setEnabled(false);
					new JOptionPane();
					JOptionPane.showMessageDialog(jlp2, "Please choose an answer");
					
				} else {
					resu[i] = jbg.getSelection().getActionCommand();
			
					brp8.setEnabled(true);
					i++;
					num.setText(i.toString());
					bg5.setText(questions.get(i));
					jt4.setEnabled(true);
				}
				
				if (i == questions.size() - 1) {
					brp8.setVisible(false);
					brp11.setVisible(true);
				}
				jbg.clearSelection();
			}
			
		});
	}
	
	public void finish1() {
		brp11.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				brp11.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				
				if(jbg.getSelection() == null) {
					brp11.setEnabled(false);
					new JOptionPane();
					JOptionPane.showMessageDialog(jlp2, "Please choose an answer");
					
				} else {
					resu[i] = jbg.getSelection().getActionCommand();
					try {
						formula();
						setScore(score);
						setExplanation(explanation);
					} catch (IOException e) {
						e.printStackTrace();
					}
					brp11.setEnabled(true);
					jlp2.setVisible(false);
					jlp3.setVisible(true);
					i = 1;
					num.setText(i.toString());
					bg5.setText(questions.get(i));
				}
			}
		});	

	}
	
	@Override
	public void formula() throws IOException {
		
		Integer tally = 0;
		
		for (int i = 0; i < resu.length; i++)
		{
			if (resu[i] == likert[1])
			{
				tally+=1;
			}
			if (resu[i] == likert[2])
			{
				tally+=2;
			}
			if (resu[i] == likert[3])
			{
				tally+=3;
			}
			
			total = tally.toString();
		}
		
		if (tally >= 0 && tally <= 5)
		{
			score = "Normal";
			a = "You are exhibiting lower normal daytime sleepiness.";
		}
		if (tally >= 6 && tally <= 10)
		{
			score = "Normal";
			a = "You are exhibiting higher normal daytime sleepiness.";
		}
		if (tally >= 11 && tally <= 12)
		{
			score = "Mild";
			a = "You are exhibiting mild excessive daytime sleepiness.";
		}
		if (tally >= 13 && tally <= 15)
		{
			score = "Moderate";
			a = "You are exhibiting moderate excessive daytime sleepiness.";
		}
		if (tally >= 16 && tally <= 24)
		{
			score = "Severe";
			a = "You are exhibiting severe excessive daytime sleepiness. Please consider seeking medical attention.";
		}
		
		explanation = "Score: " + tally + "\n" + a;
	}

	@Override
	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "ESS_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "ESS_results_" + i.toString() + ".txt";
							results = new File(path);
							i++;
					};
						br = new BufferedWriter(new FileWriter(results, true));
						br.write("NAME: " + getUName());
						br.newLine();
						br.write("AGE: " + getAge());
						br.newLine();
						br.write("GENDER: " + getGender());
						br.newLine();
						br.write("DATE: " + getUDate());
						br.newLine();
						br.write("TEST: " + getExamname());
						br.newLine();
						br.newLine();
						
						for(int j = 1; j < questions.size(); j++) {
							br.write("[" + j + "] " + questions.get(j));
							br.newLine();
							br.write(resu[j]);
							br.newLine();
							br.newLine();
						}
						
						br.write("SCORE: " + total);
						br.newLine();
						br.newLine();
						br.write(score);
						br.newLine();
						br.write(a);
						br.newLine();
						
						br.flush();
						br.close();
						
					JOptionPane.showMessageDialog(getContentPane(), "File is successfully downloaded. (" + i.toString() + ")");
					
				} catch (IOException e) {
					e.printStackTrace();
				}				
		    }

		});		
	}
	
	
}
