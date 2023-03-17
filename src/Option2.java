import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Option2 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(1) never", "(2) rarely", "(3) sometimes", "(4) often", "(5) always"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a = "";	

	public Option2() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Kessler Psychological Distress Scale (K10)");
		
		this.setInstructions("\nPlease read each statement and choose the option that best describes the amount of time "
				+ "you felt that way over the past four weeks. There are no right or wrong answers. Do not spend too much time "
				+ "on any statement.");
		
		this.setEBackground("\nThe Kessler Psychological Distress Scale is a 10-item questionnaire about emotional"
				+ " states that are measured with a five-level response scale.  It can be used as a brief screen to identify"
				+ " levels of distress.");
		
		questions.add("index zero");
		
		questions.add("In the past 4 weeks, about how often did you feel tired out for no good reason?");
		
		questions.add("In the past 4 weeks, about how often did you feel nervous?");
		
		questions.add("In the past 4 weeks, about how often did you feel so nervous that nothing could calm you down?");
		
		questions.add("In the past 4 weeks, about how often did you feel hopeless?");
		
		questions.add("In the past 4 weeks, about how often did you feel restless or fidgety?");
		
		questions.add("In the past 4 weeks, about how often did you feel so restless you could not sit still?");
		
		questions.add("In the past 4 weeks, about how often did you feel depressed?");
		
		questions.add("In the past 4 weeks, about how often did you feel that everything was an effort?");
		
		questions.add("In the past 4 weeks, about how often did you feel so sad that nothing could cheer you up?");
		
		questions.add("In the past 4 weeks, about how often did you feel worthless?");
		
		this.setQuestions(questions);
		
		this.setLikert(likert);		
		
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
			if (resu[i] == likert[0])
			{
				tally+=1;
			}
			if (resu[i] == likert[1])
			{
				tally+=2;
			}
			if (resu[i] == likert[2])
			{
				tally+=3;
			}
			if (resu[i] == likert[3])
			{
				tally+=4;
			}
			if (resu[i] == likert[4])
			{
				tally+=5;
			}
			
			total = tally.toString();
		}
		
		if (tally >= 10 && tally <= 19)
		{
			score = "Likely to be well";
			a = "You may currently not be experiencing significant feelings of distress";
		}
		if (tally >= 20 && tally <= 24)
		{
			score = "Likely to have a mild disorder";
			a = "You may be experiencing mild levels of distress consistent with a diagnosis of a mild depression and/or anxiety disorder.";
		}
		if (tally >= 25 && tally <= 29)
		{
			score = "Likely to have a moderate disorder";
			a = "You may be experiencing moderate levels of distress consistent with a diagnosis of a moderate depression and/or anxiety disorder.";
		}
		if (tally >= 30 && tally <= 50)
		{
			score = "Likely to have a severe disorder";
			a = "You may be experiencing severe levels of distress consistent with a diagnosis of a severe depression and/or anxiety disorders";
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
				String path = System.getProperty("user.home") + File.separator + "K10_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "K10_results_" + i.toString() + ".txt";
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
