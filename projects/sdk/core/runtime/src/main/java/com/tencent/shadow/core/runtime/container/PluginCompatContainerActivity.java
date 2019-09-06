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

package com.tencent.shadow.core.runtime.container;

import android.view.KeyEvent;

/**
 * 插件的容器Activity。PluginLoader将把插件的Activity放在其中。
 * PluginContainerActivity以委托模式将Activity的所有回调方法委托给DelegateProviderHolder提供的Delegate。
 *
 * @author cubershi
 */
public class PluginCompatContainerActivity extends PluginContainerActivity {

    public boolean superOnSupportNavigateUp() {
        if (hostActivityDelegate != null) {
            return hostActivityDelegate.onSupportNavigateUp();
        } else {
            return false;
        }
    }

    @Override
    public boolean superSetSupportActionBar(androidx.appcompat.widget.Toolbar toolbar) {
        if (hostActivityDelegate != null) {
            return hostActivityDelegate.setSupportActionBar(toolbar);
        } else {
            return false;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (hostActivityDelegate != null) {
            return hostActivityDelegate.dispatchKeyEvent(event);
        } else {
            return false; // super.dispatchKeyEvent(event);
        }
    }
}
