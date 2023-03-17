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
import java.util.Collections;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Option7 extends KibunTest {
	
	private ArrayList<String> questions = new ArrayList<String>(30);
	private HashSet<Integer> val = new HashSet<>();
	private String[] likert = new String[] {"(1) never", "(2) a little bit", "(3) a medium amount", "(4) a lot"};
	private String[] resu = new String[30];
	private String score = "";
	private String explanation = "";
	private String ax = "";
	private Integer sd = 0;
	private Integer ac = 0;
	private Integer d = 0;
	private Integer su = 0;
	private Integer es = 0;
	private Integer is = 0;
	private Integer bd = 0;
	private Integer v = 0;
	private Integer pf = 0;
	private Integer p = 0;
	private Integer h = 0;
	private Integer a = 0;
	private Integer r = 0;
	private Integer sb = 0;
	private Integer m = 0;


	public Option7() throws IOException {
		
		this.setVisible(true);
		
		this.setExamname("Brief-COPE (Brief-COPE)");
		
		this.setInstructions("\nPlease read each statement and choose the option that best describes how much "
				+ "you have been using that coping style. There are no right or wrong answers. Do not spend too much time "
				+ "on any statement.");
		
		this.setEBackground("\nThe Brief-COPE is a 28-item questionnaire designed to measure effective "
				+ "and ineffective ways of coping with a stressful life event. “Coping” is defined broadly as an effort "
				+ "used to minimize distress associated with negative life experiences.");
		
		questions.add("index zero");
		
		questions.add("I've been turning to work or other activities to take my mind off things.");
		
		questions.add("I've been concentrating my efforts on doing something about the situation I'm in. ");
		
		questions.add("I've been saying to myself \"this isn't real\".");
		
		questions.add("I've been using alcohol or other drugs to make myself feel better.");
		
		questions.add("I've been getting emotional support from others.");
		
		questions.add("I've been giving up trying to deal with it.");
		
		questions.add("I've been taking action to try to make the situation better.");
		
		questions.add("I've been refusing to believe that it has happened.");
		
		questions.add("I've been saying things to let my unpleasant feelings escape.");
		
		questions.add("I’ve been getting help and advice from other people.");
		
		questions.add("I've been using alcohol or other drugs to help me get through it.");
		
		questions.add("I've been trying to see it in a different light, to make it seem more positive.");
		
		questions.add("I’ve been criticizing myself.");
		
		questions.add("I've been trying to come up with a strategy about what to do.");
		
		questions.add("I've been getting comfort and understanding from someone.");
		
		questions.add("I've been giving up the attempt to cope.");
		
		questions.add("I've been looking for something good in what is happening.");
		
		questions.add("I've been making jokes about it.");
		
		questions.add("I've been doing something to think about it less, such as going to movies, watching TV, reading, daydreaming, sleeping, or shopping.");
		
		questions.add("I've been accepting the reality of the fact that it has happened.");
		
		questions.add("I've been expressing my negative feelings.");
		
		questions.add("I've been trying to find comfort in my religion or spiritual beliefs.");
		
		questions.add("I’ve been trying to get advice or help from other people about what.");
		
		questions.add("I've been learning to live with it.");
		
		questions.add("I've been thinking hard about what steps to take.");
		
		questions.add("I’ve been blaming myself for things that happened.");
		
		questions.add("I've been praying or meditating.");
		
		questions.add("I've been making fun of the situation.");
		
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

		sd = 0;
		ac = 0;
		d = 0;
		su = 0;
		es = 0;
		is = 0;
		bd = 0;
		v = 0;
		pf = 0;
		p = 0;
		h = 0;
		a = 0;
		r = 0;
		sb = 0;
		
		for (int i = 0; i < resu.length; i++)
		{				
				boolean sd1 = (i == 1 || i == 19);
				boolean ac1 = (i == 2 || i == 7);
				boolean d1 = (i == 3 || i == 8);
				boolean su1 = (i == 4 || i == 11);
				boolean es1 = (i == 5 || i == 15);
				boolean is1 = (i == 10 || i == 23);
				boolean bd1 = (i == 6 || i == 16);
				boolean v1 = (i == 9 || i == 21);
				boolean pf1 = (i == 12 || i == 17);
				boolean p1 = (i == 14 || i == 25);
				boolean h1 = (i == 18 || i == 28);
				boolean a1 = (i == 20 || i == 24);
				boolean r1 = (i == 22 || i == 27);
				boolean sb1 = (i == 13 || i == 26);

					if (resu[i] == likert[0])
					{	
						if (sd1)
						sd+=1;
						if (ac1)
						ac+=1;
						if (d1)
						d+=1;
						if (su1)
						su+=1;							
						if (es1)
						es+=1;							
						if (is1)
						is+=1;
						if (bd1)
						bd+=1;							
						if (v1)
						v+=1;							
						if (pf1)
						pf+=1;							
						if (p1)
						p+=1;								
						if (h1)
						h+=1;								
						if (a1)
						a+=1;						
						if (r1)
						r+=1;									
						if (sb1)
						sb+=1;
					}

					if (resu[i] == likert[1])
					{
						if (sd1)
						sd+=2;						
						if (ac1)
						ac+=2;						
						if (d1)
						d+=2;						
						if (su1)
						su+=2;							
						if (es1)
						es+=2;							
						if (is1)
						is+=2;						
						if (bd1)
						bd+=2;							
						if (v1)
						v+=2;							
						if (pf1)
						pf+=2;							
						if (p1)
						p+=2;								
						if (h1)
						h+=2;								
						if (a1)
						a+=2;						
						if (r1)
						r+=2;									
						if (sb1)
						sb+=2;
					}

					if (resu[i] == likert[2])
					{
						if (sd1)
						sd+=3;						
						if (ac1)
						ac+=3;
						if (d1)
						d+=3;						
						if (su1)
						su+=3;							
						if (es1)
						es+=3;							
						if (is1)
						is+=3;						
						if (bd1)
						bd+=3;							
						if (v1)
						v+=3;							
						if (pf1)
						pf+=3;							
						if (p1)
						p+=3;								
						if (h1)
						h+=3;								
						if (a1)
						a+=3;						
						if (r1)
						r+=3;									
						if (sb1)
						sb+=3;
					}
					if (resu[i] == likert[3])
					{
						if (sd1)
						sd+=4;						
						if (ac1)
						ac+=4;
						if (d1)
						d+=4;						
						if (su1)
						su+=4;							
						if (es1)
						es+=4;							
						if (is1)
						is+=4;						
						if (bd1)
						bd+=4;							
						if (v1)
						v+=4;							
						if (pf1)
						pf+=4;							
						if (p1)
						p+=4;								
						if (h1)
						h+=4;								
						if (a1)
						a+=4;						
						if (r1)
						r+=4;									
						if (sb1)
						sb+=4;
					}
					
					val.add(sd);
					val.add(ac);
					val.add(d);
					val.add(su);
					val.add(es);
					val.add(is);
					val.add(bd);
					val.add(v);
					val.add(pf);
					val.add(p);
					val.add(h);
					val.add(a);
					val.add(r);
					val.add(sb);
					
					m = Collections.max(val);		
		}

		if (sd == m)
		{
			score = "Self-distraction";
			ax = "Self-distraction is turning to work or other activities to take your mind off things/doing something to think about it less.";
		}
			
		if (ac == m)
		{
			score = "Active coping";
			ax = "Active coping is concentrating the efforts on doing something about the situation/taking action to try to make it better.";		
		}
		if (d == m)
		{
			score = "Denial";
			ax = "Denial is saying to yourself “this is not real”/refusing to believe that it has happened.";			
		}
		if (su == m)
		{
			score = "Substance use";
			ax = "Substance use is using alcohol or other drugs to feel better/to help yourself get through it.";			
		}
		if (es == m)
		{
			score = "Emotional support";
			ax = "Emotional support is obtaining emotional support/comfort and understanding.";			
		}
		if (is == m)
		{
			score = "Instrumental support";
			ax = "Instrumental support is getting help and advice from other people/trying to get advice or help from others about what to do.";			
		}
		if (bd == m)
		{
			score = "Behavioral disengagement";
			ax = "Behavioral disengagement is giving up trying to deal with it/the attempt to cope.";			
		}
		if (v == m)
		{
			score = "Venting";
			ax = "Venting is saying things to let unpleasant feelings escape/expressing negative feelings.";			
		}
		if (pf == m)
		{
			score = "Positive reframing";
			ax = "Positive reframing is trying to see the situation from a different light, make it seem more positive/look for something good in it.";			
		}
		if (p == m)
		{
			score = "Planning";
			ax = "Planning is trying to come up with a strategy about what to do/thinking hard about what steps to take.";			
		}
		if (h == m)
		{
			score = "Humor";
			ax = "Humor is making jokes about it/making fun on the situation.";			
		}
		if (a == m)
		{
			score = "Acceptance";
			ax = "Acceptance is accepting the reality that has happened/learning to live with it.";			
		}
		if (r == m)
		{
			score = "Religion";
			ax = "Religion is finding comfort in religious or spiritual beliefs/praying or meditating.";			
		}
		if (sb == m)
		{
			score = "Self-blame";
			ax = "Self-blaming is criticizing yourself/blaming yourself for things that happened.";			
		}

		explanation = "Your score highest in " + score.toLowerCase() + " as a coping style. " + ax;
	}

	@Override
	public void printr() {
		tkp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent me) {
				tkp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent me) {
				String path = System.getProperty("user.home") + File.separator + "COPE_results.txt";
				File results = new File(path);
				BufferedWriter br;
				new JOptionPane();
				try {
						Integer i = 1;
						while (results.createNewFile() == false) {
							path = System.getProperty("user.home") + File.separator + "COPE_results_" + i.toString() + ".txt";
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
						
						br.write("SELF-DISTRACTION SCORE: " + sd);
						br.newLine();
						br.write("ACTIVE COPING SCORE: " + ac);
						br.newLine();
						br.write("DENIAL SCORE: " + d);
						br.newLine();
						br.write("SUBSTANCE USE SCORE: " + su);
						br.newLine();
						br.write("EMOTIONAL SUPPORT SCORE: " + es);
						br.newLine();
						br.write("INSTRUMENTAL SUPPORT SCORE: " + is);
						br.newLine();
						br.write("BEHAVIORAL DISENGAGEMENT SCORE: " + bd);
						br.newLine();
						br.write("VENTING SCORE: " + v);
						br.newLine();
						br.write("POSITIVE REFRAMING SCORE: " + pf);
						br.newLine();
						br.write("PLANNING SCORE: " + p);
						br.newLine();
						br.write("HUMOR SCORE: " + h);
						br.newLine();
						br.write("ACCEPTANCE SCORE: " + a);
						br.newLine();
						br.write("RELIGION SCORE: " + r);
						br.newLine();
						br.write("SELF-BLAME SCORE: " + sb);
						br.newLine();
						br.newLine();
						br.write(score);
						br.newLine();
						br.write(explanation);
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
