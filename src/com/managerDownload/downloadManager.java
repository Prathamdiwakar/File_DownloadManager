package com.managerDownload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class downloadManager {
    private static final int NUM_THREADS = 4;
    private ExecutorService executorService;

    public  downloadManager() {
        executorService = Executors.newFixedThreadPool(NUM_THREADS);
    }

    public void startDownload(String[] fileUrls, String destination) {
        List<Callable<String>> tasks = new ArrayList<>();
        for (String fileUrl : fileUrls) {
            tasks.add(new DownloadTask(fileUrl, destination));
        }

        try {
            List<Future<String>> results = executorService.invokeAll(tasks);
            for (Future<String> result : results) {
                try {
                    System.out.println(result.get());
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        String[] fileUrls = {
                "http://example.com/file1.zip",
                "http://example.com/file2.zip",
                "http://example.com/file3.zip",
                "http://example.com/file4.zip"
        };

        String destination = "/path/to/save/files";

        downloadManager downloadManager = new downloadManager();
        downloadManager.startDownload(fileUrls, destination);
    }
}
