/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

import java.io.InputStream;

public class MixResources extends ResourcesWrapper {

    private Resources mHostResources;

    public MixResources(Resources hostResources,Resources pluginResources) {
        super(pluginResources);
        mHostResources = hostResources;
    }

    @Override
    public CharSequence getText(int id) throws NotFoundException {
        try {
            return super.getText(id);
        } catch (NotFoundException e) {
            return mHostResources.getText(id);
        }
    }

    @Override
    public String getString(int id) throws NotFoundException {
        try {
            return super.getString(id);
        } catch (NotFoundException e) {
            return mHostResources.getString(id);
        }
    }

    @Override
    public String getString(int id, Object... formatArgs) throws NotFoundException {
        try {
            return super.getString(id,formatArgs);
        } catch (NotFoundException e) {
            return mHostResources.getString(id,formatArgs);
        }
    }

    @Override
    public float getDimension(int id) throws NotFoundException {
        try {
            return super.getDimension(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimension(id);
        }
    }

    @Override
    public int getDimensionPixelOffset(int id) throws NotFoundException {
        try {
            return super.getDimensionPixelOffset(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimensionPixelOffset(id);
        }
    }

    @Override
    public int getDimensionPixelSize(int id) throws NotFoundException {
        try {
            return super.getDimensionPixelSize(id);
        } catch (NotFoundException e) {
            return mHostResources.getDimensionPixelSize(id);
        }
    }

    @Override
    public Drawable getDrawable(int id) throws NotFoundException {
        return getDrawable(id, null);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Drawable getDrawable(int id, Theme theme) throws NotFoundException {
        try {
            return super.getDrawable(id, theme);
        } catch (NotFoundException e) {
            try {
                return ResourcesCompat.getDrawable(mHostResources, id, theme);
            } catch (NotFoundException ex) {
                Log.e("MixResources", "getDrawable", ex);
                return null;
            }
        }
    }

    @Override
    public Drawable getDrawableForDensity(int id, int density) throws NotFoundException {
        return getDrawableForDensity(id, density, null);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public Drawable getDrawableForDensity(int id, int density, Theme theme) {
        try {
            return super.getDrawableForDensity(id, density, theme);
        } catch (Exception e) {
            return ResourcesCompat.getDrawableForDensity(mHostResources, id, density, theme);
        }
    }

    @Override
    public int getColor(int id) throws NotFoundException {
        return getColor(id, null);
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getColor(int id, Theme theme) throws NotFoundException {
        try {
            return super.getColor(id, theme);
        } catch (NotFoundException e) {
            return ResourcesCompat.getColor(mHostResources, id, theme);
        }
    }

    @Override
    public ColorStateList getColorStateList(int id) throws NotFoundException {
        try {
            return super.getColorStateList(id);
        } catch (NotFoundException e) {
            return mHostResources.getColorStateList(id);
        }
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ColorStateList getColorStateList(int id, Theme theme) throws NotFoundException {
        try {
            return super.getColorStateList(id,theme);
        } catch (NotFoundException e) {
            return mHostResources.getColorStateList(id,theme);
        }
    }

    @Override
    public boolean getBoolean(int id) throws NotFoundException {
        try {
            return super.getBoolean(id);
        } catch (NotFoundException e) {
            return mHostResources.getBoolean(id);
        }
    }

    @Override
    public XmlResourceParser getLayout(int id) throws NotFoundException {
        try {
            return super.getLayout(id);
        } catch (NotFoundException e) {
           return mHostResources.getLayout(id);
        }
    }

    @Override
    public String getResourceName(int resid) throws NotFoundException {
        try {
            return super.getResourceName(resid);
        } catch (NotFoundException e) {
            return mHostResources.getResourceName(resid);
        }
    }

    @Override
    public int getInteger(int id) throws NotFoundException {
        try {
            return super.getInteger(id);
        } catch (NotFoundException e) {
            return mHostResources.getInteger(id);
        }
    }

    @Override
    public CharSequence getText(int id, CharSequence def) {
        try {
            return super.getText(id,def);
        } catch (NotFoundException e) {
            return mHostResources.getText(id,def);
        }
    }

    @Override
    public InputStream openRawResource(int id) throws NotFoundException {
        try {
            return super.openRawResource(id);
        } catch (NotFoundException e) {
            return mHostResources.openRawResource(id);
        }

    }

    @Override
    public XmlResourceParser getXml(int id) throws NotFoundException {
        try {
            return super.getXml(id);
        } catch (NotFoundException e) {
            return mHostResources.getXml(id);
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public Typeface getFont(int id) throws NotFoundException {
        try {
            return super.getFont(id);
        } catch (NotFoundException e) {
            return mHostResources.getFont(id);
        }
    }

    @Override
    public Movie getMovie(int id) throws NotFoundException {
        try {
            return super.getMovie(id);
        } catch (NotFoundException e) {
            return mHostResources.getMovie(id);
        }
    }

    @Override
    public XmlResourceParser getAnimation(int id) throws NotFoundException {
        try {
            return super.getAnimation(id);
        } catch (NotFoundException e) {
            return mHostResources.getAnimation(id);
        }
    }

    @Override
    public InputStream openRawResource(int id, TypedValue value) throws NotFoundException {
        try {
            return super.openRawResource(id,value);
        } catch (NotFoundException e) {
            return mHostResources.openRawResource(id,value);
        }
    }

    @Override
    public AssetFileDescriptor openRawResourceFd(int id) throws NotFoundException {
        try {
            return super.openRawResourceFd(id);
        } catch (NotFoundException e) {
            return mHostResources.openRawResourceFd(id);
        }
    }

    @Override
    public String getResourcePackageName(int resid) throws NotFoundException {
        try {
            return super.getResourcePackageName(resid);
        } catch (NotFoundException e) {
            return mHostResources.getResourcePackageName(resid);
        }
    }

    @Override
    public String getResourceEntryName(int resid) throws NotFoundException {
        try {
            return super.getResourceEntryName(resid);
        } catch (NotFoundException e) {
            return mHostResources.getResourceEntryName(resid);
        }
    }

    @Override
    public String getResourceTypeName(int resid) throws NotFoundException {
        try {
            return super.getResourceTypeName(resid);
        } catch (NotFoundException e) {
            return mHostResources.getResourceTypeName(resid);
        }
    }

    @Override
    public void getValue(int id, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            super.getValue(id, outValue, resolveRefs);
        } catch (NotFoundException e) {
            mHostResources.getValue(id, outValue, resolveRefs);
        }
    }

    @Override
    public int getIdentifier(String name, String defType, String defPackage) {
        try {
            return super.getIdentifier(name, defType, defPackage);
        } catch (Exception e) {
            return mHostResources.getIdentifier(name, defType, defPackage);
        }
    }

    @Override
    public void getValue(String name, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            super.getValue(name, outValue, resolveRefs);
        } catch (NotFoundException e) {
            mHostResources.getValue(name, outValue, resolveRefs);
        }
    }

    @Override
    public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) throws NotFoundException {
        try {
            super.getValueForDensity(id, density, outValue, resolveRefs);
        } catch (NotFoundException e) {
            mHostResources.getValueForDensity(id, density, outValue, resolveRefs);
        }
    }

    @Override
    public CharSequence[] getTextArray(int id) throws NotFoundException {
        try {
            return super.getTextArray(id);
        } catch (NotFoundException e) {
            return mHostResources.getTextArray(id);
        }
    }

    @Override
    public float getFraction(int id, int base, int pbase) {
        try {
            return super.getFraction(id, base, pbase);
        } catch (Exception e) {
            return mHostResources.getFraction(id, base, pbase);
        }
    }

    @Override
    public TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        try {
            return super.obtainAttributes(set, attrs);
        } catch (Exception e) {
            return mHostResources.obtainAttributes(set, attrs);
        }
    }

    @Override
    public TypedArray obtainTypedArray(int id) throws NotFoundException {
        try {
            return super.obtainTypedArray(id);
        } catch (NotFoundException e) {
            return mHostResources.obtainTypedArray(id);
        }
    }

    @Override
    public Configuration getConfiguration() {
        try {
            return super.getConfiguration();
        } catch (Exception e) {
            return mHostResources.getConfiguration();
        }
    }
}
