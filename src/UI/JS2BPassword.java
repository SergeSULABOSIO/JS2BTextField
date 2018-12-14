package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.Icon;
import javax.swing.JPasswordField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class JS2BPassword extends JPasswordField implements FocusListener{

    private Icon icon;
    private String textInitial;
    private final Insets dummyInsets = new Insets(1, 5, 1, 1);

    public JS2BPassword() {
        super();
        this.icon = null;
        setEchoChar('*');
        this.setFont(new java.awt.Font("Cambria", 1, 12));
        addFocusListener(this);
    }

    public String getTextInitial() {
        return textInitial;
    }

    public void setTextInitial(String textInitial) {
        this.textInitial = textInitial;
        setForeground(new java.awt.Color(153, 153, 153));
        setText(textInitial);
    }
    
    public void focusG(){
        String holder = getText();
        if(!holder.equals(textInitial)){
            setText(holder);
            setForeground(Color.BLACK);
        }
    }
    
    @Override
    public String getText(){
        String tex = super.getText();
        if(tex.equals(textInitial)){
            return "";
        }else{
            return tex;
        }
    }
    
    public void focusL(){
        String holder = getText();
        if(holder.trim().equals("")){
            setText(textInitial);
            setForeground(new java.awt.Color(153, 153, 153));
        }
    }


    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getIcon() {
        return this.icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int textX = 2;

        if (this.icon != null) {
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            int x = dummyInsets.left + 2;//this is our icon's x
            textX = x + iconWidth + 2; //this is the x where text should start
            int y = (this.getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g, x, y);
        }
        setMargin(new Insets(2, textX, 2, 2));
        
    }
    

    public static void main(String[] args) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        focusG();
    }

    @Override
    public void focusLost(FocusEvent e) {
        focusL();
    }


}
