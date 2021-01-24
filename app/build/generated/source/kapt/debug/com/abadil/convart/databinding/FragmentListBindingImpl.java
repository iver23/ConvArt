package com.abadil.convart.databinding;
import com.abadil.convart.R;
import com.abadil.convart.BR;
import com.abadil.convart.ui.FragmentListViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentListBindingImpl extends FragmentListBinding implements com.abadil.convart.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.points_recyclerview, 5);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.Button mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener idEtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of myViewModel.inputDesignation.getValue()
            //         is myViewModel.inputDesignation.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(idEt);
            // localize variables for thread safety
            // myViewModel.inputDesignation.getValue()
            java.lang.String myViewModelInputDesignationGetValue = null;
            // myViewModel.inputDesignation
            androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputDesignation = null;
            // myViewModel.inputDesignation != null
            boolean myViewModelInputDesignationJavaLangObjectNull = false;
            // myViewModel
            FragmentListViewModel myViewModel = mMyViewModel;
            // myViewModel != null
            boolean myViewModelJavaLangObjectNull = false;



            myViewModelJavaLangObjectNull = (myViewModel) != (null);
            if (myViewModelJavaLangObjectNull) {


                myViewModelInputDesignation = myViewModel.getInputDesignation();

                myViewModelInputDesignationJavaLangObjectNull = (myViewModelInputDesignation) != (null);
                if (myViewModelInputDesignationJavaLangObjectNull) {




                    myViewModelInputDesignation.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener xEtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of myViewModel.inputX.getValue()
            //         is myViewModel.inputX.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(xEt);
            // localize variables for thread safety
            // myViewModel.inputX
            androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputX = null;
            // myViewModel.inputX != null
            boolean myViewModelInputXJavaLangObjectNull = false;
            // myViewModel.inputX.getValue()
            java.lang.String myViewModelInputXGetValue = null;
            // myViewModel
            FragmentListViewModel myViewModel = mMyViewModel;
            // myViewModel != null
            boolean myViewModelJavaLangObjectNull = false;



            myViewModelJavaLangObjectNull = (myViewModel) != (null);
            if (myViewModelJavaLangObjectNull) {


                myViewModelInputX = myViewModel.getInputX();

                myViewModelInputXJavaLangObjectNull = (myViewModelInputX) != (null);
                if (myViewModelInputXJavaLangObjectNull) {




                    myViewModelInputX.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener yEtandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of myViewModel.inputY.getValue()
            //         is myViewModel.inputY.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(yEt);
            // localize variables for thread safety
            // myViewModel.inputY
            androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputY = null;
            // myViewModel.inputY != null
            boolean myViewModelInputYJavaLangObjectNull = false;
            // myViewModel.inputY.getValue()
            java.lang.String myViewModelInputYGetValue = null;
            // myViewModel
            FragmentListViewModel myViewModel = mMyViewModel;
            // myViewModel != null
            boolean myViewModelJavaLangObjectNull = false;



            myViewModelJavaLangObjectNull = (myViewModel) != (null);
            if (myViewModelJavaLangObjectNull) {


                myViewModelInputY = myViewModel.getInputY();

                myViewModelInputYJavaLangObjectNull = (myViewModelInputY) != (null);
                if (myViewModelInputYJavaLangObjectNull) {




                    myViewModelInputY.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentListBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private FragmentListBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            );
        this.idEt.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView4 = (android.widget.Button) bindings[4];
        this.mboundView4.setTag(null);
        this.xEt.setTag(null);
        this.yEt.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.abadil.convart.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.myViewModel == variableId) {
            setMyViewModel((FragmentListViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMyViewModel(@Nullable FragmentListViewModel MyViewModel) {
        updateRegistration(0, MyViewModel);
        this.mMyViewModel = MyViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.myViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeMyViewModel((FragmentListViewModel) object, fieldId);
            case 1 :
                return onChangeMyViewModelInputDesignation((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeMyViewModelInputX((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeMyViewModelInputY((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeMyViewModel(FragmentListViewModel MyViewModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.inputDesignation) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.inputX) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.inputY) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMyViewModelInputDesignation(androidx.lifecycle.MutableLiveData<java.lang.String> MyViewModelInputDesignation, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMyViewModelInputX(androidx.lifecycle.MutableLiveData<java.lang.String> MyViewModelInputX, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeMyViewModelInputY(androidx.lifecycle.MutableLiveData<java.lang.String> MyViewModelInputY, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String myViewModelInputDesignationGetValue = null;
        FragmentListViewModel myViewModel = mMyViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputDesignation = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputX = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> myViewModelInputY = null;
        java.lang.String myViewModelInputYGetValue = null;
        java.lang.String myViewModelInputXGetValue = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x13L) != 0) {

                    if (myViewModel != null) {
                        // read myViewModel.inputDesignation
                        myViewModelInputDesignation = myViewModel.getInputDesignation();
                    }
                    updateLiveDataRegistration(1, myViewModelInputDesignation);


                    if (myViewModelInputDesignation != null) {
                        // read myViewModel.inputDesignation.getValue()
                        myViewModelInputDesignationGetValue = myViewModelInputDesignation.getValue();
                    }
            }
            if ((dirtyFlags & 0x15L) != 0) {

                    if (myViewModel != null) {
                        // read myViewModel.inputX
                        myViewModelInputX = myViewModel.getInputX();
                    }
                    updateLiveDataRegistration(2, myViewModelInputX);


                    if (myViewModelInputX != null) {
                        // read myViewModel.inputX.getValue()
                        myViewModelInputXGetValue = myViewModelInputX.getValue();
                    }
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (myViewModel != null) {
                        // read myViewModel.inputY
                        myViewModelInputY = myViewModel.getInputY();
                    }
                    updateLiveDataRegistration(3, myViewModelInputY);


                    if (myViewModelInputY != null) {
                        // read myViewModel.inputY.getValue()
                        myViewModelInputYGetValue = myViewModelInputY.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x13L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.idEt, myViewModelInputDesignationGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.idEt, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, idEtandroidTextAttrChanged);
            this.mboundView4.setOnClickListener(mCallback1);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.xEt, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, xEtandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.yEt, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, yEtandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.xEt, myViewModelInputXGetValue);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.yEt, myViewModelInputYGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // myViewModel
        FragmentListViewModel myViewModel = mMyViewModel;
        // myViewModel != null
        boolean myViewModelJavaLangObjectNull = false;



        myViewModelJavaLangObjectNull = (myViewModel) != (null);
        if (myViewModelJavaLangObjectNull) {


            myViewModel.addPoint();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): myViewModel
        flag 1 (0x2L): myViewModel.inputDesignation
        flag 2 (0x3L): myViewModel.inputX
        flag 3 (0x4L): myViewModel.inputY
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}