/*
 * Njiwa Open Source Embedded M2M UICC Remote Subscription Manager
 * 
 * 
 * Copyright (C) 2019 - , Digital Solutions Ltd. - http://www.dsmagic.com
 *
 * Njiwa Dev <dev@njiwa.io>
 * 
 * This program is free software, distributed under the terms of
 * the GNU General Public License.
 */ 

/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package io.njiwa.dp.pedefinitions;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.BerLength;
import org.openmuc.jasn1.ber.types.BerOctetString;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FileManagement {

	public static class CHOICE {

		public byte[] code = null;
		private BerOctetString filePath = null;

		private Fcp createFCP = null;

		private UInt16 fillFileOffset = null;

		private BerOctetString fillFileContent = null;

		public CHOICE() {
		}

		public CHOICE(byte[] code) {
			this.code = code;
		}

		public void setFilePath(BerOctetString filePath) {
			this.filePath = filePath;
		}

		public BerOctetString getFilePath() {
			return filePath;
		}

		public void setCreateFCP(Fcp createFCP) {
			this.createFCP = createFCP;
		}

		public Fcp getCreateFCP() {
			return createFCP;
		}

		public void setFillFileOffset(UInt16 fillFileOffset) {
			this.fillFileOffset = fillFileOffset;
		}

		public UInt16 getFillFileOffset() {
			return fillFileOffset;
		}

		public void setFillFileContent(BerOctetString fillFileContent) {
			this.fillFileContent = fillFileContent;
		}

		public BerOctetString getFillFileContent() {
			return fillFileContent;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (fillFileContent != null) {
				codeLength += fillFileContent.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
				return codeLength;

			}
			
			if (fillFileOffset != null) {
				codeLength += fillFileOffset.encode(os, true);
				return codeLength;

			}
			
			if (createFCP != null) {
				codeLength += createFCP.encode(os, false);
				// write tag: APPLICATION_CLASS, CONSTRUCTED, 2
				os.write(0x62);
				codeLength += 1;
				return codeLength;

			}
			
			if (filePath != null) {
				codeLength += filePath.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				os.write(0x80);
				codeLength += 1;
				return codeLength;

			}
			
			throw new IOException("Error encoding BerChoice: No item in choice was selected.");
		}

		public int decode(InputStream is, BerIdentifier berIdentifier) throws IOException {
			int codeLength = 0;
			BerIdentifier passedIdentifier = berIdentifier;

			if (berIdentifier == null) {
				berIdentifier = new BerIdentifier();
				codeLength += berIdentifier.decode(is);
			}

			BerLength length = new BerLength();
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				filePath = new BerOctetString();
				codeLength += filePath.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				createFCP = new Fcp();
				codeLength += createFCP.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(UInt16.identifier)) {
				fillFileOffset = new UInt16();
				codeLength += fillFileOffset.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				fillFileContent = new BerOctetString();
				codeLength += fillFileContent.decode(is, false);
				return codeLength;
			}

			if (passedIdentifier != null) {
				return 0;
			}
			throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			if ( filePath!= null) {
				return "CHOICE{filePath: " + filePath + "}";
			}

			if ( createFCP!= null) {
				return "CHOICE{createFCP: " + createFCP + "}";
			}

			if ( fillFileOffset!= null) {
				return "CHOICE{fillFileOffset: " + fillFileOffset + "}";
			}

			if ( fillFileContent!= null) {
				return "CHOICE{fillFileContent: " + fillFileContent + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	private List<CHOICE> seqOf = null;

	public FileManagement() {
		id = identifier;
		seqOf = new ArrayList<CHOICE>();
	}

	public FileManagement(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public List<CHOICE> getCHOICE() {
		if (seqOf == null) {
			seqOf = new ArrayList<CHOICE>();
		}
		return seqOf;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(os, true);
			}

			codeLength += BerLength.encodeLength(os, codeLength);

		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();
		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);
		int totalLength = length.val;

		while (subCodeLength < totalLength) {
			CHOICE element = new CHOICE();
			subCodeLength += element.decode(is, null);
			seqOf.add(element);
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE OF{");

		if (seqOf == null) {
			sb.append("null");
		}
		else {
			Iterator<CHOICE> it = seqOf.iterator();
			if (it.hasNext()) {
				sb.append(it.next());
				while (it.hasNext()) {
					sb.append(", ").append(it.next());
				}
			}
		}

		sb.append("}");

		return sb.toString();
	}

}

