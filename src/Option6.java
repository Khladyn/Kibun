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

public class Option6 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(1) strongly disagree", "(2) disagree", "(3) neutral", "(4) agree", "(5) strongly agree"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String total = "";
	private String a = "";	

	public Option6() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Open Hemispheric Brain Dominance Scale");
		
		this.setInstructions("\nPlease read each statement and rate the item by how much you agree. "
				+ "There are no right or wrong answers. Do not spend too much time on any statement.");
		
		this.setEBackground("\nThe Open Hemispheric Brain Dominance Scale is a 20-item questionnaire that "
				+ "measures the so called \"right brain\"/\"left brain\" personality distinction. The biological distinction is "
				+ "scientifically discredited, but the personality distinction remains a popular descriptive system. ");
		
		questions.add("index zero");
		
		questions.add("I do not need others praise.");
		
		questions.add("I would prefer a class in mathematics to a class in pottery.");
		
		questions.add("I never show up late.");
		
		questions.add("I don't bother to the read instructions before I start putting something together.");
		
		questions.add("I could not live in a mess.");
		
		questions.add("I am totally random.");
		
		questions.add("I like working with words.");
		
		questions.add("I behave in a businesslike manner.");
		
		questions.add("I come up with something new.");
		
		questions.add("I am not easily disturbed by events.");
		
		questions.add("I rarely cry during sad movies.");
		
		questions.add("I plan my life logically.");
		
		questions.add("I need a creative outlet.");
		
		questions.add("I make decisions based on facts, not feelings.");
		
		questions.add("I make a mess of things.");
		
		questions.add("I get stressed out easily.");
		
		questions.add("I am romantic.");
		
		questions.add("I prize logic above all else.");
		
		questions.add("I often forget to put things back in their proper place.");
		
		questions.add("I am calm even in tense situations.");
		
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
		
		Integer l = 0;
		Integer r = 0;
		
		for (int i = 0; i < resu.length; i++)
		{			
			boolean b = (i == 1 || i == 2 || i == 3 || i == 5 || i == 8 || i == 10
			|| i == 11 || i == 12 || i == 14 || i == 18 || i == 20);			
			
			if (resu[i] == likert[0])
			{
				if (b)
				l+=1;
				else
				r+=1;
			}
			if (resu[i] == likert[1])
			{
				if (b)
				l+=2;
				else
				r+=2;
			}
			if (resu[i] == likert[2])
			{
				if (b)
				l+=3;
				
				else
				r+=3;
			}
			if (resu[i] == likert[3])
			{
				if (b)
				l+=4;
				else
				r+=4;
			}
			if (resu[i] == likert[4])
			{
				if (b)
				l+=5;
				else
				r+=5;
			}	
			
			tally = (66 - l) + r;
			total = tally.toString();
			
		}
		
		if (tally >= 20 && tally <= 55)
		{
			score = "Left-brained";
			a = "Left-brain characteristics include: verbal, logical, linear, concrete, time oriented, and details. "
					+ "You may want to try outlines, lecture notes, or the Cornell Format as study tools.";
		}
		if (tally >= 56 && tally <= 64)
		{
			score = "No clear preference";
		}
		if (tally >= 65 && tally <= 100)
		{
			score = "Right-brained";
			a = "Right-brain characteristics include: visual, intuitive, holistic, abstract, spacial and main ideas. "
					+ "You may want to try charts, maps, time lines, graphs, or visualization as study tools.";
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
				String path = System.getProperty("user.home") + File.separator + "OHBDS_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "OHBDS_results_" + i.toString() + ".txt";
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
