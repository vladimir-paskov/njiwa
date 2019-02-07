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


public class PERFM {

	public static class TarList {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		private List<BerOctetString> seqOf = null;

		public TarList() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public TarList(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public List<BerOctetString> getBerOctetString() {
			if (seqOf == null) {
				seqOf = new ArrayList<BerOctetString>();
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
				BerOctetString element = new BerOctetString();
				subCodeLength += element.decode(is, true);
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
				Iterator<BerOctetString> it = seqOf.iterator();
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

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	private PEHeader rfmHeader = null;

	private ApplicationIdentifier instanceAID = null;

	private ApplicationIdentifier securityDomainAID = null;

	private TarList tarList = null;

	private BerOctetString minimumSecurityLevel = null;

	private BerOctetString uiccAccessDomain = null;

	private BerOctetString uiccAdminAccessDomain = null;

	private ADFRFMAccess adfRFMAccess = null;

	public PERFM() {
		id = identifier;
	}

	public PERFM(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public void setRfmHeader(PEHeader rfmHeader) {
		this.rfmHeader = rfmHeader;
	}

	public PEHeader getRfmHeader() {
		return rfmHeader;
	}

	public void setInstanceAID(ApplicationIdentifier instanceAID) {
		this.instanceAID = instanceAID;
	}

	public ApplicationIdentifier getInstanceAID() {
		return instanceAID;
	}

	public void setSecurityDomainAID(ApplicationIdentifier securityDomainAID) {
		this.securityDomainAID = securityDomainAID;
	}

	public ApplicationIdentifier getSecurityDomainAID() {
		return securityDomainAID;
	}

	public void setTarList(TarList tarList) {
		this.tarList = tarList;
	}

	public TarList getTarList() {
		return tarList;
	}

	public void setMinimumSecurityLevel(BerOctetString minimumSecurityLevel) {
		this.minimumSecurityLevel = minimumSecurityLevel;
	}

	public BerOctetString getMinimumSecurityLevel() {
		return minimumSecurityLevel;
	}

	public void setUiccAccessDomain(BerOctetString uiccAccessDomain) {
		this.uiccAccessDomain = uiccAccessDomain;
	}

	public BerOctetString getUiccAccessDomain() {
		return uiccAccessDomain;
	}

	public void setUiccAdminAccessDomain(BerOctetString uiccAdminAccessDomain) {
		this.uiccAdminAccessDomain = uiccAdminAccessDomain;
	}

	public BerOctetString getUiccAdminAccessDomain() {
		return uiccAdminAccessDomain;
	}

	public void setAdfRFMAccess(ADFRFMAccess adfRFMAccess) {
		this.adfRFMAccess = adfRFMAccess;
	}

	public ADFRFMAccess getAdfRFMAccess() {
		return adfRFMAccess;
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
			if (adfRFMAccess != null) {
				codeLength += adfRFMAccess.encode(os, true);
			}
			
			codeLength += uiccAdminAccessDomain.encode(os, true);
			
			codeLength += uiccAccessDomain.encode(os, true);
			
			codeLength += minimumSecurityLevel.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			if (tarList != null) {
				codeLength += tarList.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
				os.write(0xa0);
				codeLength += 1;
			}
			
			if (securityDomainAID != null) {
				codeLength += securityDomainAID.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				os.write(0x4f);
				codeLength += 1;
			}
			
			codeLength += instanceAID.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 15
			os.write(0x4f);
			codeLength += 1;
			
			codeLength += rfmHeader.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
			codeLength += 1;
			
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
		codeLength += totalLength;

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			rfmHeader = new PEHeader();
			subCodeLength += rfmHeader.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			instanceAID = new ApplicationIdentifier();
			subCodeLength += instanceAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			securityDomainAID = new ApplicationIdentifier();
			subCodeLength += securityDomainAID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			tarList = new TarList();
			subCodeLength += tarList.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			minimumSecurityLevel = new BerOctetString();
			subCodeLength += minimumSecurityLevel.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerOctetString.identifier)) {
			uiccAccessDomain = new BerOctetString();
			subCodeLength += uiccAccessDomain.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerOctetString.identifier)) {
			uiccAdminAccessDomain = new BerOctetString();
			subCodeLength += uiccAdminAccessDomain.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(ADFRFMAccess.identifier)) {
			adfRFMAccess = new ADFRFMAccess();
			subCodeLength += adfRFMAccess.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("rfmHeader: ").append(rfmHeader);
		
		sb.append(", ");
		sb.append("instanceAID: ").append(instanceAID);
		
		if (securityDomainAID != null) {
			sb.append(", ");
			sb.append("securityDomainAID: ").append(securityDomainAID);
		}
		
		if (tarList != null) {
			sb.append(", ");
			sb.append("tarList: ").append(tarList);
		}
		
		sb.append(", ");
		sb.append("minimumSecurityLevel: ").append(minimumSecurityLevel);
		
		sb.append(", ");
		sb.append("uiccAccessDomain: ").append(uiccAccessDomain);
		
		sb.append(", ");
		sb.append("uiccAdminAccessDomain: ").append(uiccAdminAccessDomain);
		
		if (adfRFMAccess != null) {
			sb.append(", ");
			sb.append("adfRFMAccess: ").append(adfRFMAccess);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

