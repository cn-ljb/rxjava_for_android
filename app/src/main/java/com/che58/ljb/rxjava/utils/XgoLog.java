package com.che58.ljb.rxjava.utils;

import android.util.Log;

public final class XgoLog {

	/** 是否允许输出log
	 *  -1：  不允许
	 *  其他：根据等级允许
	 * */
	private static int mDebuggable = 10;

	/** 日志输出时的TAG */

	private static String mTag = "xgo";


	/** 日志输出级别NONE */
	public static final int LEVEL_NONE = 0;


	/** 日志输出级别V */

	public static final int LEVEL_VERBOSE = 1;

	/** 日志输出级别D */

	public static final int LEVEL_DEBUG = 2;

	/** 日志输出级别I */

	public static final int LEVEL_INFO = 3;

	/** 日志输出级别W */

	public static final int LEVEL_WARN = 4;

	/** 日志输出级别E */

	public static final int LEVEL_ERROR = 5;

	private XgoLog() throws InstantiationException {
		throw new InstantiationException("This class is not created for instantiation");
	}

	/** 以级别为v 的形式输出LOG */

	public static void v(String msg) {

		if (mDebuggable >= LEVEL_VERBOSE) {

			Log.v(mTag, msg);

		}

	}

	/** 以级别为 d 的形式输出LOG */

	public static void d(String msg) {

		if (mDebuggable >= LEVEL_DEBUG) {

			Log.d(mTag, msg);

		}

	}

	/** 以级别为 i 的形式输出LOG */

	public static void i(String msg) {

		if (mDebuggable >= LEVEL_INFO) {

			Log.i(mTag, msg);

		}

	}

	/** 以级别为 w 的形式输出LOG */

	public static void w(String msg) {

		if (mDebuggable >= LEVEL_WARN) {

			Log.w(mTag, msg);

		}

	}

	/** 以级别为 w 的形式输出Throwable */

	public static void w(Throwable tr) {

		if (mDebuggable >= LEVEL_WARN) {

			Log.w(mTag, "", tr);

		}

	}

	/** 以级别为 w 的形式输出LOG信息和Throwable */

	public static void w(String msg, Throwable tr) {

		if (mDebuggable >= LEVEL_WARN && null != msg) {

			Log.w(mTag, msg, tr);

		}

	}

	/** 以级别为 e 的形式输出LOG */

	public static void e(String msg) {

		if (mDebuggable >= LEVEL_ERROR) {

			Log.e(mTag, msg);

		}

	}

	/** 以级别为 e 的形式输出Throwable */

	public static void e(Throwable tr) {

		if (mDebuggable >= LEVEL_ERROR) {

			Log.e(mTag, "", tr);

		}

	}

	/** 以级别为 e 的形式输出LOG信息和Throwable */

	public static void e(String msg, Throwable tr) {

		if (mDebuggable >= LEVEL_ERROR && null != msg) {

			Log.e(mTag, msg, tr);

		}

	}

}
