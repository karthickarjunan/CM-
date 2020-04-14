package com.cm.checkin;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class BaseTest extends Constant {


	
public static void RobotPopup(String uname,String pass) throws Exception
{
	 Robot rb = new Robot();
     StringSelection username = new StringSelection(uname);
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);            
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);
     rb.keyRelease(KeyEvent.VK_V);
     rb.keyRelease(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_TAB);
     rb.keyRelease(KeyEvent.VK_TAB);
     Thread.sleep(2000);
     StringSelection pwd = new StringSelection(pass);
     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
     rb.keyPress(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_V);
     rb.keyRelease(KeyEvent.VK_V);
     rb.keyRelease(KeyEvent.VK_CONTROL);
     rb.keyPress(KeyEvent.VK_ENTER);
     rb.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(5000);
 
}
public static void RobotEnter() throws Exception
{
	
	 Robot rb = new Robot();
     rb.keyPress(KeyEvent.VK_ENTER);
     rb.keyRelease(KeyEvent.VK_ENTER);
     Thread.sleep(1000);
 
}
public static void VShortWait() throws Exception
{
     Thread.sleep(2000);
 
}
public static void ShortWait() throws Exception
{
     Thread.sleep(5000);
 
}
public static void LongWait() throws Exception
{
     Thread.sleep(10000);
 
}
}
