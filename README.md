# Demonstrates an instrumentation testing bug with multiple spinners + espresso

Using multiple `Spinner`s is not possible with Espresso. It appears that the second `onData` is being run before the drop down from the `Spinner` has fully disappeared.

[Relevant activity is here.](app/src/main/java/gd/not/testapplication/MainActivity.java)

[Relevant test case is here.](app/src/androidTest/java/gd/not/testapplication/MainActivityTest.java)

See stack trace:

```
12-14 12:08:54.186 16151-16175/gd.not.testapplication I/TestRunner: run started: 1 tests
12-14 12:08:54.195 16151-16175/gd.not.testapplication I/TestRunner: started: testMultipleSpinners(gd.not.testapplication.MainActivityTest)
12-14 12:08:54.199 16151-16151/gd.not.testapplication I/MonitoringInstrumentation: Activities that are still in CREATED to STOPPED: 0
12-14 12:08:54.199 16151-16175/gd.not.testapplication D/ActivityInstrumentationRule: Launching activity gd.not.testapplication.MainActivity
12-14 12:08:54.202 16151-16176/gd.not.testapplication D/MonitoringInstrumentation: execStartActivity(context, ibinder, ibinder, activity, intent, int, bundle
12-14 12:08:54.452 16151-16151/gd.not.testapplication D/LifecycleMonitor: Lifecycle status change: gd.not.testapplication.MainActivity@5aadb03 in: PRE_ON_CREATE
12-14 12:08:54.495 16151-16157/gd.not.testapplication W/art: Suspending all threads took: 6.729ms
12-14 12:08:54.851 16151-16151/gd.not.testapplication D/LifecycleMonitor: Lifecycle status change: gd.not.testapplication.MainActivity@5aadb03 in: CREATED
12-14 12:08:54.853 16151-16151/gd.not.testapplication D/LifecycleMonitor: Lifecycle status change: gd.not.testapplication.MainActivity@5aadb03 in: STARTED
12-14 12:08:54.859 16151-16151/gd.not.testapplication D/LifecycleMonitor: Lifecycle status change: gd.not.testapplication.MainActivity@5aadb03 in: RESUMED
12-14 12:08:54.878 16151-16187/gd.not.testapplication D/OpenGLRenderer: Use EGL_SWAP_BEHAVIOR_PRESERVED: true

                                                                        [ 12-14 12:08:54.889 16151:16151 D/         ]
                                                                        HostConnection::get() New Host Connection established 0x7f1ac3fc3c60, tid 16151


                                                                        [ 12-14 12:08:55.114 16151:16187 D/         ]
                                                                        HostConnection::get() New Host Connection established 0x7f1ac41bbf80, tid 16187
12-14 12:08:55.128 16151-16187/gd.not.testapplication I/OpenGLRenderer: Initialized EGL, version 1.4
12-14 12:08:55.351 16151-16187/gd.not.testapplication W/EGL_emulation: eglSurfaceAttrib not implemented
12-14 12:08:55.351 16151-16187/gd.not.testapplication W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0x7f1ac799dcc0, error=EGL_SUCCESS
12-14 12:08:55.649 16151-16175/gd.not.testapplication D/InputManagerEventInjectionStrategy: Creating injection strategy with input manager.
12-14 12:08:55.678 16151-16151/gd.not.testapplication I/ViewInteraction: Performing 'load adapter data' action on view with id: gd.not.testapplication:id/spinner1
12-14 12:08:55.796 16151-16151/gd.not.testapplication I/ViewInteraction: Performing 'single click' action on view  displaying data matching: with toString() "Spinner 1 bar" within adapter view matching: with id: gd.not.testapplication:id/spinner1
12-14 12:08:55.893 16151-16187/gd.not.testapplication W/EGL_emulation: eglSurfaceAttrib not implemented
12-14 12:08:55.893 16151-16187/gd.not.testapplication W/OpenGLRenderer: Failed to set EGL_SWAP_BEHAVIOR on surface 0x7f1aba24ba80, error=EGL_SUCCESS
12-14 12:08:56.296 16151-16175/gd.not.testapplication I/TestRunner: failed: testMultipleSpinners(gd.not.testapplication.MainActivityTest)
12-14 12:08:56.296 16151-16175/gd.not.testapplication I/TestRunner: ----- begin exception -----
12-14 12:08:56.296 16151-16151/gd.not.testapplication D/LifecycleMonitor: Lifecycle status change: gd.not.testapplication.MainActivity@5aadb03 in: PAUSED
12-14 12:08:56.296 16151-16175/gd.not.testapplication I/TestRunner: android.support.test.espresso.NoMatchingViewException: No views in hierarchy found matching: with id: gd.not.testapplication:id/spinner2
                                                                    If the target view is not part of the view hierarchy, you may need to use Espresso.onData to load it from one of the following AdapterViews:android.widget.ListPopupWindow$DropDownListView{5c660c2 VFED.VC.. .F...... 0,0-656,192}

                                                                    View Hierarchy:
                                                                    +>PopupDecorView{id=-1, visibility=VISIBLE, width=656, height=192, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1}
                                                                    |
                                                                    +->PopupBackgroundView{id=-1, visibility=VISIBLE, width=656, height=192, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1}
                                                                    |
                                                                    +-->DropDownListView{id=-1, visibility=VISIBLE, width=656, height=192, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=true, is-focusable=true, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2}
                                                                    |
                                                                    +--->AppCompatCheckedTextView{id=16908308, res-name=text1, visibility=VISIBLE, width=656, height=96, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, text=Spinner 1 foo, input-type=0, ime-target=false, has-links=false, is-checked=false}
                                                                    |
                                                                    +--->AppCompatCheckedTextView{id=16908308, res-name=text1, visibility=VISIBLE, width=656, height=96, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=96.0, text=Spinner 1 bar, input-type=0, ime-target=false, has-links=false, is-checked=true}
                                                                    |
                                                                        at dalvik.system.VMStack.getThreadStackTrace(Native Method)
                                                                        at java.lang.Thread.getStackTrace(Thread.java:580)
                                                                        at android.support.test.espresso.base.DefaultFailureHandler.getUserFriendlyError(DefaultFailureHandler.java:82)
                                                                        at android.support.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:53)
                                                                        at android.support.test.espresso.ViewInteraction.runSynchronouslyOnUiThread(ViewInteraction.java:184)
                                                                        at android.support.test.espresso.ViewInteraction.doPerform(ViewInteraction.java:115)
                                                                        at android.support.test.espresso.ViewInteraction.perform(ViewInteraction.java:87)
                                                                        at android.support.test.espresso.DataInteraction.load(DataInteraction.java:151)
                                                                        at android.support.test.espresso.DataInteraction.perform(DataInteraction.java:128)
                                                                        at gd.not.testapplication.MainActivityTest.testMultipleSpinners(MainActivityTest.java:32)
                                                                        at java.lang.reflect.Method.invoke(Native Method)
                                                                        at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
                                                                        at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
                                                                        at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
                                                                        at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
                                                                        at android.support.test.internal.statement.UiThreadStatement.evaluate(UiThreadStatement.java:55)
                                                                        at android.support.test.rule.ActivityTestRule$ActivityStatement.evaluate(ActivityTestRule.java:257)
                                                                        at org.junit.rules.RunRules.evaluate(RunRules.java:20)
                                                                        at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
                                                                        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
                                                                        at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
                                                                    	at org.junit.ru
12-14 12:08:56.296 16151-16175/gd.not.testapplication I/TestRunner: ----- end exception -----
12-14 12:08:56.297 16151-16175/gd.not.testapplication I/TestRunner: finished: testMultipleSpinners(gd.not.testapplication.MainActivityTest)
```