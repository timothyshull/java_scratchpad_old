package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloJava
{
	public static void main( String[] args ) {
		JFrame frame = new JFrame( "HelloJava2" ); 
		frame.getContentPane().add( new HelloComponent("Hello, Java!") ); 
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
		frame.setSize( 300, 300 );
		frame.setVisible( true );
	} 
}
