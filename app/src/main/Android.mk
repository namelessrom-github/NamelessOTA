LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

# Cardview Dir
cardview_dir := $(LOCAL_PATH)/../../../../../../frameworks/support/v7/cardview/res

LOCAL_CERTIFICATE       := platform
LOCAL_MODULE_TAGS       := optional
LOCAL_PACKAGE_NAME      := BlissOTA
LOCAL_PRIVILEGED_MODULE := true

LOCAL_STATIC_JAVA_LIBRARIES := \
	RootTools \
	android-support-v4 \
	android-support-v7-cardview

LOCAL_PROGUARD_ENABLED := disabled

LOCAL_AAPT_FLAGS := \
	--auto-add-overlay \
	--extra-packages android.support.v7.cardview \
	--extra-packages RootTools

LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res $(cardview_dir)
LOCAL_SRC_FILES    := $(call all-java-files-under,java)

include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := libs/RootTools.jar

include $(BUILD_MULTI_PREBUILT)
