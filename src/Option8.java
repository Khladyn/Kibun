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

public class Option8 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(0) strongly disagree", "(1) disagree", "(2) agree", "(3) strongly agree"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a ="";	

	public Option8() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Rosenberg Self-Esteem Scale (RSES)");
		
		this.setInstructions("\nPlease read each statement and rate the item by how much you agree. "
				+ "There are no right or wrong answers. Do not spend too much time on any statement.");
		
		this.setEBackground("\nThe Rosenberg Self-Esteem Scale is a 10-item questionnaire that is a measure of "
				+ "global self-esteem. It consists of statements related to overall feelings of "
				+ "self-worth or self-acceptance.");
		
		questions.add("index zero");
		
		questions.add("On the whole, I am satisfied with myself.");
		
		questions.add("At times I think I am no good at all.");
		
		questions.add("I feel that I have a number of good qualities.");
		
		questions.add("I am able to do things as well as most other people.");
		
		questions.add("I feel I do not have much to be proud of.");
		
		questions.add("I certainly feel useless at times.");
		
		questions.add("I feel that I'm a person of worth, at least on an equal plane with others.");
		
		questions.add("I wish I could have more respect for myself.");
		
		questions.add("All in all, I am inclined to feel that I am a failure.");
		
		questions.add("I take a positive attitude toward myself.");
		
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
			
			boolean r = (i == 2 || i == 5 || i == 6 || i == 8 || i == 9);
			
			if (resu[i] == likert[0])
			{
				if (r)
				tally+=3;
				else
				tally+=0;
			}
			if (resu[i] == likert[1])
			{
				if (r)
				tally+=2;
				else
				tally+=1;
			}
			if (resu[i] == likert[2])
			{
				if (r)
				tally+=1;
				else
				tally+=2;
			}
			if (resu[i] == likert[3])
			{
				if (r)
				tally+=0;
				else
				tally+=3;
			}
		}
		
		total = tally.toString();
		
		if (tally >= 0 && tally <= 14)
		{
			score = "Low";
			a = "People who have low self esteem, think of themselves as below average. "
					+ "Some of the effects of low self-esteem are poor relationships, addiction, depression and anxiety.";
		}
		if (tally >= 15 && tally <= 24)
		{
			score = "Normal";
			a = "You seem to have a normal self-esteem.";
		}
		if (tally >= 25 && tally <= 30)
		{
			score = "High";
			a = "People who have high self-esteem tend to love and accept themselves. "
					+ "Some of the benefits of high self-esteem includes being able to be yourself without the fear of being judged "
					+ "and readiness to accept new challenges.";
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
				String path = System.getProperty("user.home") + File.separator + "RSES_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "RSES_results_" + i.toString() + ".txt";
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
						br.newLine();
						br.write("NOTE: Scores for items 2, 5, 6, 8 and 9 are reversed.");
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
