package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.util.ArrayList;

/**
 * @PanelEmoticons.java
 * 
 * Clase encargada de cargar los emoticones
 * */
public class PanelEmoticons extends JPanel {
	private static final long serialVersionUID = 1L;

    public static Chat    chat;
    @SuppressWarnings("unused")
    
	Emoticons         emoticonos;
    
	private ArrayList<JButton> buttonsEmoticons;
	
	public PanelEmoticons(Chat c){
		
		chat = c;
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		init();		
	
		for( int index = 0; index < Emoticons.shortCuts.size(); index++ )		
			
			addEmoticono(Emoticons.shortCuts.get(index), Emoticons.path + index + ".png");
					
		this.setPreferredSize(new Dimension(700,60));
		setVisible(true);
	}
	
	private void init(){
		emoticonos       = new Emoticons(); 
		
		buttonsEmoticons = new  ArrayList<JButton>();		
	}	
	/**
	 * Agrega un emoticono.
	 * 
	 * @param atajo clave en la tabla hash.
	 * @param url valor en la tabla hash.
	 * */
	public void addEmoticono(String atajo, String ruta){
				
		ImageIcon imgTmp = new ImageIcon(getClass().getResource(ruta));
		JButton   btTemp = new JButton("");
		
		btTemp.setIcon(imgTmp);
		btTemp.setPreferredSize(new Dimension(40,26));
		btTemp.setFocusable(false);
		btTemp.setContentAreaFilled(false);
		btTemp.setToolTipText(atajo);
		btTemp.addActionListener(new listerner());
		
		buttonsEmoticons.add(btTemp);
		
		add(btTemp);			
	}
}
/***
 * Listerner
 **/
class listerner implements ActionListener{
	public listerner(){}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton)e.getSource();
		
		PanelEmoticons.chat.insertString(" "+button.getToolTipText()+" ");	
	   }
	}