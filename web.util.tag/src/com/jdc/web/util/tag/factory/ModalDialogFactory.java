package com.jdc.web.util.tag.factory;

import com.jdc.web.util.tag.BasicTag;
import com.jdc.web.util.tag.Tag;

public class ModalDialogFactory implements AbstractTagFactory{
	
	private Tag tag;
	
	public ModalDialogFactory() {
		tag = new ModalDialog();
	}

	@Override
	public Tag create() {
		return tag;
	}

	@Deprecated
	@Override
	public AbstractTagFactory styleClass(String styleClass) {
		return this;
	}
	
	private class ModalDialog extends BasicTag {

		public ModalDialog() {
			super("div");
		}
		
	}

}
