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
import org.openmuc.jasn1.ber.types.BerObjectIdentifier;
import org.openmuc.jasn1.ber.types.BerOctetString;
import org.openmuc.jasn1.ber.types.string.BerUTF8String;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProfileHeader {

	public static class EUICCMandatoryGFSTEList {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		private List<BerObjectIdentifier> seqOf = null;

		public EUICCMandatoryGFSTEList() {
			id = identifier;
			seqOf = new ArrayList<BerObjectIdentifier>();
		}

		public EUICCMandatoryGFSTEList(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public List<BerObjectIdentifier> getBerObjectIdentifier() {
			if (seqOf == null) {
				seqOf = new ArrayList<BerObjectIdentifier>();
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
				BerObjectIdentifier element = new BerObjectIdentifier();
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
				Iterator<BerObjectIdentifier> it = seqOf.iterator();
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
	private UInt8 majorVersion = null;

	private UInt8 minorVersion = null;

	private BerUTF8String profileType = null;

	private BerOctetString iccid = null;

	private BerOctetString pol = null;

	private ServicesList eUICCMandatoryServices = null;

	private EUICCMandatoryGFSTEList eUICCMandatoryGFSTEList = null;

	private BerOctetString connectivityParameters = null;

	public ProfileHeader() {
		id = identifier;
	}

	public ProfileHeader(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public void setMajorVersion(UInt8 majorVersion) {
		this.majorVersion = majorVersion;
	}

	public UInt8 getMajorVersion() {
		return majorVersion;
	}

	public void setMinorVersion(UInt8 minorVersion) {
		this.minorVersion = minorVersion;
	}

	public UInt8 getMinorVersion() {
		return minorVersion;
	}

	public void setProfileType(BerUTF8String profileType) {
		this.profileType = profileType;
	}

	public BerUTF8String getProfileType() {
		return profileType;
	}

	public void setIccid(BerOctetString iccid) {
		this.iccid = iccid;
	}

	public BerOctetString getIccid() {
		return iccid;
	}

	public void setPol(BerOctetString pol) {
		this.pol = pol;
	}

	public BerOctetString getPol() {
		return pol;
	}

	public void setEUICCMandatoryServices(ServicesList eUICCMandatoryServices) {
		this.eUICCMandatoryServices = eUICCMandatoryServices;
	}

	public ServicesList getEUICCMandatoryServices() {
		return eUICCMandatoryServices;
	}

	public void setEUICCMandatoryGFSTEList(EUICCMandatoryGFSTEList eUICCMandatoryGFSTEList) {
		this.eUICCMandatoryGFSTEList = eUICCMandatoryGFSTEList;
	}

	public EUICCMandatoryGFSTEList getEUICCMandatoryGFSTEList() {
		return eUICCMandatoryGFSTEList;
	}

	public void setConnectivityParameters(BerOctetString connectivityParameters) {
		this.connectivityParameters = connectivityParameters;
	}

	public BerOctetString getConnectivityParameters() {
		return connectivityParameters;
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
			if (connectivityParameters != null) {
				codeLength += connectivityParameters.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 7
				os.write(0x87);
				codeLength += 1;
			}
			
			codeLength += eUICCMandatoryGFSTEList.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			os.write(0xa6);
			codeLength += 1;
			
			codeLength += eUICCMandatoryServices.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			os.write(0xa5);
			codeLength += 1;
			
			if (pol != null) {
				codeLength += pol.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				os.write(0x84);
				codeLength += 1;
			}
			
			codeLength += iccid.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
			
			if (profileType != null) {
				codeLength += profileType.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
			}
			
			codeLength += minorVersion.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			codeLength += majorVersion.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			majorVersion = new UInt8();
			subCodeLength += majorVersion.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			minorVersion = new UInt8();
			subCodeLength += minorVersion.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			profileType = new BerUTF8String();
			subCodeLength += profileType.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			iccid = new BerOctetString();
			subCodeLength += iccid.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			pol = new BerOctetString();
			subCodeLength += pol.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			eUICCMandatoryServices = new ServicesList();
			subCodeLength += eUICCMandatoryServices.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			eUICCMandatoryGFSTEList = new EUICCMandatoryGFSTEList();
			subCodeLength += eUICCMandatoryGFSTEList.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			connectivityParameters = new BerOctetString();
			subCodeLength += connectivityParameters.decode(is, false);
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
		sb.append("majorVersion: ").append(majorVersion);
		
		sb.append(", ");
		sb.append("minorVersion: ").append(minorVersion);
		
		if (profileType != null) {
			sb.append(", ");
			sb.append("profileType: ").append(profileType);
		}
		
		sb.append(", ");
		sb.append("iccid: ").append(iccid);
		
		if (pol != null) {
			sb.append(", ");
			sb.append("pol: ").append(pol);
		}
		
		sb.append(", ");
		sb.append("eUICCMandatoryServices: ").append(eUICCMandatoryServices);
		
		sb.append(", ");
		sb.append("eUICCMandatoryGFSTEList: ").append(eUICCMandatoryGFSTEList);
		
		if (connectivityParameters != null) {
			sb.append(", ");
			sb.append("connectivityParameters: ").append(connectivityParameters);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

