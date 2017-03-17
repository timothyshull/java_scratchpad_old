package ch_1;

import sun.net.ProgressEvent;
import sun.net.ProgressListener;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

public class Downloader extends Thread {
    class NewListener implements ProgressListener {
        @Override
        public void progressStart(ProgressEvent progressEvent) {
            return;
        }

        @Override
        public void progressUpdate(ProgressEvent progressEvent) {
            return;
        }

        @Override
        public void progressFinish(ProgressEvent progressEvent) {
            return;
        }

        public void onProgress(int i) {
            return;
        }
    }

    private InputStream in;
    private OutputStream out;
    private ArrayList<NewListener> listeners;

    public Downloader(URL url, String outputFilename) throws IOException {
        this.in = url.openConnection().getInputStream();
        this.out = new FileOutputStream(outputFilename);
        this.listeners = new ArrayList<NewListener>();
    }

    public synchronized void addListener(NewListener listener) {
        this.listeners.add(listener);
    }

    public synchronized void removeListener(NewListener listener) {
        listeners.remove(listener);
    }

    public void updateProgress(int n) {
        ArrayList<NewListener> listenersCopy;

        synchronized (this) {
            listenersCopy = new ArrayList<NewListener>(listeners);
        }
        for (NewListener listener : listenersCopy)
            listener.onProgress(n);
    }

    public void run() {
        int n = 0, total = 0;
        byte[] buffer = new byte[1024];

        try {
            while ((n = in.read(buffer)) != -1) {
                out.write(buffer, 0, n);
                total += n;
                updateProgress(total);
            }
            out.flush();
        } catch (IOException e) { }
    }
}
