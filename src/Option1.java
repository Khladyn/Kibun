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
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Option1 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private String[] likert = new String[] {"(0) never", "(1) sometimes", "(2) often", "(3) almost always"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String a1 = "";	
	private String a2 = "";	
	private String a3 = "";	
	private Integer dd = 0;
	private Integer aa = 0;
	private Integer ss = 0;

	public Option1() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Depression Anxiety Stress Scale (DASS-21)");
		
		this.setInstructions("\nPlease read each statement and choose the option that best describes the amount of time "
				+ "you felt that way over the past week. There are no right or wrong answers. Do not spend too much time "
				+ "on any statement.");
		
		this.setEBackground("\nThe Depression Anxiety Stress Scale is a 21-item questionnaire"
				+ " that assesses levels of hopelessness, self-deprecation, and inertia under the"
				+ " depression subscale; subjective experience of anxious effect under the anxiety subscale, and"
				+ " nervous arousal and agitation under the stress subscale.");
		
		questions.add("index zero");
		
		questions.add("I found it hard to wind down");
		
		questions.add("I was aware of dryness of my mouth");
		
		questions.add("I couldn’t seem to experience any positive feeling at all");
		
		questions.add("I experienced breathing difficulty (eg, excessively rapid breathing, breathlessness in the absence of physical exertion)");
		
		questions.add("I found it difficult to work up the initiative to do things");
		
		questions.add("I tended to over-react to situations");
		
		questions.add("I experienced trembling (eg, in the hands)");
		
		questions.add("I felt that I was using a lot of nervous energy");
		
		questions.add("I was worried about situationsin which I might panic and make a fool of myself");
		
		questions.add("I felt that I had nothing to look forward to");
		
		questions.add("I found myself getting agitated");
		
		questions.add("I found it difficult to relax");
		
		questions.add("I felt down-hearted and blue");
		
		questions.add("I was intolerant of anything that kept me from getting on with what I was doing");
		
		questions.add("I felt I was close to panic");
		
		questions.add("I was unable to become enthusiastic about anything");
		
		questions.add("I felt I wasn’t worth much as a person");
		
		questions.add("I felt that I was rather touchy");
		
		questions.add("I was aware of the action of my heart in the absence of physicalexertion (eg, sense of heart rate increase, heart missing a beat)");
		
		questions.add("I felt scared without any good reason");
		
		questions.add("I felt that life was meaningless");
		
		this.setQuestions(questions);
		
		this.setLikert(likert);		
	}
	
	@Override
	public JTextPane getExp(String s)
	{
		Border fbord = BorderFactory.createEmptyBorder(10,20,20,20);
		JTextPane jt = new JTextPane();
		jt.setText(s);
		jt.setOpaque(true);
		jt.setFont(new Font("Metropolis Medium", Font.PLAIN, 16));
		jt.setForeground(new Color(255,255,240,255));
		jt.setBackground(new Color(17,75,95,255));
		jt.setBorder(fbord);
		jt.setSize(550, 125);
		jt.setEditable(false);
		
		StyledDocument sd = jt.getStyledDocument();
		SimpleAttributeSet st = new SimpleAttributeSet();
		StyleConstants.setAlignment(st, StyleConstants.ALIGN_CENTER);
		sd.setParagraphAttributes(0, sd.getLength(), st, false);
		
		return jt;
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

		dd = 0;
		aa = 0;
		ss = 0;
		
		for (int i = 0; i < resu.length; i++)
		{				
				boolean dds = (i == 3 || i == 5 || i == 10 || i == 13
						|| i == 16 || i == 17 || i == 21);

				boolean aas = (i == 2 || i == 4 || i == 7 || i == 9
						|| i == 15 || i == 19 || i == 20);

				boolean sss = (i == 1 || i == 6 || i == 8 || i == 11
						|| i == 12 || i == 14 || i == 18);

				
					if (resu[i] == likert[1])
					{	
						if (dds)
						dd+=1;
						
						if (aas)
						aa+=1;
						
						if (sss)
						ss+=1;
					}

					if (resu[i] == likert[2])
					{
						
						if (dds)
						dd+=2;
							
						if (aas)
						aa+=2;
							
						if (sss)
						ss+=2;
					}

					if (resu[i] == likert[3])
					{
						
						if (dds)
						dd+=3;
							
						if (aas)
						aa+=3;
							
						if (sss)
						ss+=3;
					}
			
		}
		
		if (dd*2 >= 0 && dd*2 <= 9)
		{
			a1 = "You are exhibiting normal depression";
		}
		if (dd*2 >= 10 && dd*2 <= 13)
		{
			a1 = "You are exhibiting mild depression";
		}
		if (dd*2 >= 14 && dd*2 <= 20)
		{
			a1 = "You are exhibiting moderate depression";
		}
		if (dd*2 >= 21 && dd*2 <= 27)
		{
			a1 = "You are exhibiting severe depression";
		}
		if (dd*2 >= 28)
		{
			a1 = "You are exhibiting extremely severe depression";
		}
		
		
		if (aa*2 >= 0 && aa*2 <= 7)
		{
			a2 = "You are exhibiting normal anxiety";
		}
		if (aa*2 >= 8 && aa*2 <= 9)
		{
			a2 = "You are exhibiting mild anxiety";
		}
		if (aa*2 >= 10 && aa*2 <= 14)
		{
			a2 = "You are exhibiting moderate anxiety";
		}
		if (aa*2 >= 15 && aa*2 <= 19)
		{
			a2 = "You are exhibiting severe anxiety";
		}
		if (aa*2 >= 20)
		{
			a2 = "You are exhibiting extremely severe anxiety";
		}
		
		
		if (ss*2 >= 0 && ss*2 <= 14)
		{
			a3 = "You are exhibiting normal stress";
		}
		if (ss*2 >= 15 && ss*2 <= 18)
		{
			a3 = "You are exhibiting mild stress";
		}
		if (ss*2 >= 19 && ss*2 <= 25)
		{
			a3 = "You are exhibiting moderate stress";
		}
		if (ss*2 >= 26 && ss*2 <= 33)
		{
			a3 = "You are exhibiting severe stress";
		}
		if (ss*2 >= 34)
		{
			a3 = "You are exhibiting extremely severe stress";
		}
		
		explanation = "Depression Score: " + dd*2 + "\n" + a1 + "\n"
				+ "Anxiety Score: " + aa*2 + "\n" + a2 + "\n"
				+ "Stress Score: " + ss*2 + "\n" + a3;
		
		if (ss > aa && ss > dd)
			score = "You are mostly stressed";
		if (aa > ss && aa > dd)
			score = "You are mostly anxious";
		if (dd > aa && dd > ss)
			score = "You are mostly depressed";
		if (ss == aa && ss == dd && dd == aa)
			score = "You score equally";
		
	}

	@Override
	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "DASS_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "DASS_results_" + i.toString() + ".txt";
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
						
						br.write("DEPRESSION SCORE: " + dd*2);
						br.newLine();
						br.write("ANXIETY SCORE: " + aa*2);
						br.newLine();
						br.write("STRESS SCORE: " + ss*2);
						br.newLine();
						br.newLine();
						br.write(a1);
						br.newLine();
						br.write(a2);
						br.newLine();
						br.write(a3);
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
