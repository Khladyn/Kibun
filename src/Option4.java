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
import java.util.PriorityQueue;

import javax.swing.JOptionPane;

public class Option4 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(1)", "(2)", "(3)", "(4)", "(5)"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a = "";
	private Integer pa = 0;
	private Integer va = 0;
	private Integer ag = 0;
	private Integer h = 0;
	
//	beck = 17 -80

	public Option4() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Buss-Perry Aggression Questionnaire (BPAQ)");
		
		this.setInstructions("\n1 = extremely uncharacteristic of me, "
				+ "2 = somewhat uncharacteristic of me, 3 = neither uncharacteristic nor characteristic of me, "
				+ "4 = somewhat characteristic of me, 5 = extremely characteristic of me");
		
		this.setEBackground("\nThe Buss–Perry Aggression Questionnaire is a 29-item questionnaire that measures "
				+ "aggression in four factors: physical aggression, verbal aggression, anger, and hostility.");
		
		questions.add("index zero");
		
		questions.add("Some of my friends think I am a hothead.");
		
		questions.add("If I have to resort to violence to protect my rights, I will.");
		
		questions.add("When people are especially nice to me, I wonder what they want.");
		
		questions.add("I tell my friends openly when I disagree with them.");
		
		questions.add("I have become so mad that I have broken things.");
		
		questions.add("I can’t help getting into arguments when people disagree with me.");
		
		questions.add("I wonder why sometimes I feel so bitter about things.");
		
		questions.add("Once in a while, I can’t control the urge to strike another person.");
		
		questions.add("I am an even-tempered person.");
		
		questions.add("I am suspicious of overly friendly strangers.");
		
		questions.add("I have threatened people I know.");
		
		questions.add("I flare up quickly but get over it quickly.");
		
		questions.add("Given enough provocation, I may hit another person.");
		
		questions.add("When people annoy me, I may tell them what I think of them.");
		
		questions.add("I am sometimes eaten up with jealousy.");
		
		questions.add("I can think of no good reason for ever hitting a person.");
		
		questions.add("At times I feel I have gotten a raw deal out of life.");
		
		questions.add("I have trouble controlling my temper.");
		
		questions.add("When frustrated, I let my irritation show.");
		
		questions.add("I sometimes feel that people are laughing at me behind my back.");
		
		questions.add("I often find myself disagreeing with people.");
		
		questions.add("If somebody hits me, I hit back.");
		
		questions.add("I sometimes feel like a powder keg ready to explode.");
		
		questions.add("Other people always seem to get the breaks.");
		
		questions.add("There are people who pushed me so far that we came to blows.");
		
		questions.add("I know that “friends” talk about me behind my back.");
		
		questions.add("My friends say that I’m somewhat argumentative.");
		
		questions.add("Sometimes I fly off the handle for no good reason.");
		
		questions.add("I get into fights a little more than the average person.");
		
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
	
	@Override
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
		pa = 0;
		va = 0;
		ag = 0;
		h = 0;
		
		for (int i = 0; i < resu.length; i++)
		{				
				boolean ags = (i == 1 || i == 12 || i == 18 || i == 19
						|| i == 23 || i == 28);
				
				boolean hs = (i == 3 || i == 7 || i == 10 || i == 15
						|| i == 17 || i == 20 || i == 24
						|| i == 26);
				
				boolean pas = (i == 2 || i == 5 || i == 8 || i == 11
						|| i == 13 || i == 22 || i == 25
						|| i == 29);
				
				boolean vas = (i == 4 || i == 6 || i == 14 || i == 21
						|| i == 27);
			
					if (resu[i] == likert[0])
					{
						if(i == 9)
						ag+=5;
						
						if(i == 16)
						pa+=5;
						
						if (ags)
						ag+=1;
						
						if (hs)
						h+=1;
						
						if (pas)
						pa+=1;
						
						if (vas)
						va+=1;

					}

					if (resu[i] == likert[1])
					{
						
						if(i == 9)
						ag+=4;
							
						if(i == 16)
						pa+=4;
						
						if (ags)
						ag+=2;
						
						if (hs)
						h+=2;
						
						if (pas)
						pa+=2;
						
						if (vas)
						va+=2;
					}

					if (resu[i] == likert[2])
					{
						
						if (ags)
						ag+=3;
							
						if (hs)
						h+=3;
							
						if (pas)
						pa+=3;
							
						if (vas)
						va+=3;
					}

					if (resu[i] == likert[3])
					{						
						if(i == 9)
						ag+=2;
								
						if(i == 16)
						pa+=2;
						
						if (ags)
						ag+=4;
							
						if (hs)
						h+=4;
							
						if (pas)
						pa+=4;
							
						if (vas)
						va+=4;
					}

					if (resu[i] == likert[4])
					{
						if(i == 9)
						ag+=1;
									
						if(i == 16)
						pa+=1;
						
						if (ags)
						ag+=5;
							
						if (hs)
						h+=5;
							
						if (pas)
						pa+=5;
							
						if (vas)
						va+=5;
					}
					
			tally = va + pa + ag + h;
			total = tally.toString();
		}
		
		if (h > ag && h > va && h > pa)
		{
			score = "Hostility";
			a = "You scored highest in hostility with a score of: " + h
					+ "\nVerbal Aggression score: " + va
					+ "\nPhysical Aggression score: " + pa
					+ "\nAnger score: " + ag;
		}
		if (va > h && va > pa && va > ag)
		{
			score = "Verbal Aggression";
			a = "You scored highest in verbal aggression with a score of: " + va
					+ "\nPhysical Aggression score: " + pa
					+ "\nAnger score: " + ag
					+ "\nHostility score: " + h;
		}
		if (pa > va && pa > h && pa > ag)
		{
			score = "Physical Aggression";
			a = "You scored highest in physical aggression with a score of: " + pa
					+ "\nAnger score: " + ag
					+ "\nHostility score: " + h
					+ "\nVerbal Aggression score: " + va;
		}	
		if (ag > va && ag > h && ag > pa)
		{
			score = "Anger";
			a = "You scored highest in anger with a score of: " + ag
					+ "\nHostility score: " + h
					+ "\nVerbal Aggression score: " + va
					+ "\nPhysical Aggression score: " + pa;
		}
		
		explanation = "Total Aggression score: " + tally + "\n" + a;
	}

	@Override
	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "BPAQ_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "BPAQ_results_" + i.toString() + ".txt";
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
						br.write("SCALE: ");
						br.newLine();
						br.write("1 = extremely uncharacteristic of me");
						br.newLine();
						br.write("2 = somewhat uncharacteristic of me");
						br.newLine();
						br.write("3 = neither uncharacteristic nor characteristic of me");
						br.newLine();
						br.write("4 = somewhat characteristic of me");
						br.newLine();
						br.write("5 = extremely characteristic of me");
						br.newLine();
						br.newLine();
						
						for(int j = 1; j < questions.size(); j++) {
							br.write("[" + j + "] " + questions.get(j));
							br.newLine();
							br.write(resu[j]);
							br.newLine();
							br.newLine();
						}
						
						br.write("TOTAL SCORE: " + total);
						br.newLine();
						br.write("PHYSICAL AGGRESSION SCORE: " + pa);
						br.newLine();
						br.write("VERBAL AGRESSION SCORE: " + va);
						br.newLine();
						br.write("HOSTILITY SCORE: " + h);
						br.newLine();
						br.write("ANGER SCORE: " + ag);
						br.newLine();
						br.newLine();
						br.write(score);
						br.newLine();
						br.write(a);
						br.newLine();
						br.newLine();
						br.write("NOTE: Scores for items 9 and 16 are reversed.");
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
