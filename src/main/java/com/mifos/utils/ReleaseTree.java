package com.mifos.utils;

import android.util.LruCache;

import timber.log.Timber;

public class ReleaseTree extends Timber.DebugTree {

  private final LruCache<Integer, String> inMemoryLogBuffer;
  private int number;


  public ReleaseTree(LruCache<Integer, String> inMemoryLogBuffer) {
    this.inMemoryLogBuffer = inMemoryLogBuffer;
    number = 0;

  }

  protected void log(int priority, String tag, String message, Throwable t) {
    if(message.length() < 4000) {
      inMemoryLogBuffer.put(number++, tag + ":" + priority + ":" + message);
    } else {
      int i = 0;

      int end;
      for(int length = message.length(); i < length; i = end + 1) {
        int newline = message.indexOf(10, i);
        newline = newline != -1?newline:length;

        do {
          end = Math.min(newline, i + 4000);
          String part = message.substring(i, end);
          inMemoryLogBuffer.put(number++, tag + ":" + priority + ":" + part);
          i = end;
        } while(end < newline);
      }

    }
  }
}
