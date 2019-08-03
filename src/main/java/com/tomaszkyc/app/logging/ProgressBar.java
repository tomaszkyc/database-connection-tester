package com.tomaszkyc.app.logging;

/**
 * Ascii progress meter. On completion this will reset itself,
 * so it can be reused
 * <br /><br />
 * 100% ################################################## |
 */
public class ProgressBar {
    private StringBuilder progress;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private int limit;
    /**
     * initialize progress bar properties.
     */
    public ProgressBar(int limit) {
        this.limit = limit;
        init();
    }

    /**
     * called whenever the progress bar needs to be updated.
     * that is whenever progress was made.
     *
     * @param done an int representing the work done so far
     * @param limit an int representing the total work
     */
    public void update(int done) {
        char[] workchars = {'|', '/', '-', '\\'};
        String format = "\r%3d%% %s %c" + System.lineSeparator();

        int percent = (done++ * 100) / limit;
        int extrachars = (percent / 2) - this.progress.length();

        while (extrachars-- > 0) {
            progress.append('#');
        }

        System.out.printf(format, percent, progress,
                workchars[done % workchars.length]);

        if (done == limit) {
            System.out.flush();
            System.out.println();
            init();
        }
    }

    private void init() {
        this.progress = new StringBuilder(60);
    }
}
