package Test.Controller.FocusTime;

import Controller.FocusTime.FocusTimeThread;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Created by AldoBalderrama on 8/1/2016.
 */
public class FocusTimeThreadTest {
    @Test
    public void runOneThreadWithFocusTimeThreadClass() throws InterruptedException, IOException {
        FocusTimeThread focusTimeThread = new FocusTimeThread(1);
        focusTimeThread.start();
        Process process = Runtime.getRuntime().exec("notepad");
        Thread.sleep(1000);
        focusTimeThread.interrupt();
        process.destroy();
        assertTrue(focusTimeThread.getApplicationNameList().contains("Notepad"));
    }
}
