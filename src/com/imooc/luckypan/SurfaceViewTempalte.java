package com.imooc.luckypan;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class SurfaceViewTempalte extends SurfaceView implements Callback,
		Runnable {

	private SurfaceHolder mHolder;
	private Canvas mCanvas;

	/*
	 * 用于绘制的线程
	 */
	private Thread t;

	/*
	 * 线程的控制开关
	 */
	private boolean isRunning;

	public SurfaceViewTempalte(Context context) {
		super(context);

	}

	public SurfaceViewTempalte(Context context, AttributeSet attrs) {
		super(context, attrs);

		mHolder = getHolder();

		mHolder.addCallback(this);

		// 可获得焦点
		setFocusable(true);
		setFocusableInTouchMode(true);

		// 设置常量
		setKeepScreenOn(true);
	}

	public void surfaceCreated(SurfaceHolder holder) {

		isRunning = true;

		t = new Thread(this);
		t.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

		isRunning = false;
	}

	public void run() {
		// 不断进行绘制
		while (isRunning) {
			draw();
		}
	}

	private void draw() {

		try {
			mCanvas = mHolder.lockCanvas();

			if (mCanvas != null) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (mCanvas != null) {
				mHolder.unlockCanvasAndPost(mCanvas);
			}
		}
	}
}
