/**
 * This class file was automatically generated by jASN1 v1.8.2 (http://www.openmuc.org)
 */

package org.onosproject.xran.asn1lib.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import org.onosproject.xran.asn1lib.ber.BerByteArrayOutputStream;
import org.onosproject.xran.asn1lib.ber.BerLength;
import org.onosproject.xran.asn1lib.ber.BerTag;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ERABParams implements Serializable {

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    public byte[] code = null;
    private List<ERABParamsItem> seqOf = null;

    public ERABParams() {
        seqOf = new ArrayList<ERABParamsItem>();
    }

    public ERABParams(byte[] code) {
        this.code = code;
    }

    @JsonValue
    public List<ERABParamsItem> getERABParamsItem() {
        if (seqOf == null) {
            seqOf = new ArrayList<ERABParamsItem>();
        }
        return seqOf;
    }

    public int encode(BerByteArrayOutputStream os) throws IOException {
        return encode(os, true);
    }

    public int encode(BerByteArrayOutputStream os, boolean withTag) throws IOException {

        if (code != null) {
            for (int i = code.length - 1; i >= 0; i--) {
                os.write(code[i]);
            }
            if (withTag) {
                return tag.encode(os) + code.length;
            }
            return code.length;
        }

        int codeLength = 0;
        for (int i = (seqOf.size() - 1); i >= 0; i--) {
            codeLength += seqOf.get(i).encode(os, true);
        }

        codeLength += BerLength.encodeLength(os, codeLength);

        if (withTag) {
            codeLength += tag.encode(os);
        }

        return codeLength;
    }

    public int decode(InputStream is) throws IOException {
        return decode(is, true);
    }

    public int decode(InputStream is, boolean withTag) throws IOException {
        int codeLength = 0;
        int subCodeLength = 0;
        if (withTag) {
            codeLength += tag.decodeAndCheck(is);
        }

        BerLength length = new BerLength();
        codeLength += length.decode(is);
        int totalLength = length.val;

        while (subCodeLength < totalLength) {
            ERABParamsItem element = new ERABParamsItem();
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
        StringBuilder sb = new StringBuilder();
        appendAsString(sb, 0);
        return sb.toString();
    }

    public void appendAsString(StringBuilder sb, int indentLevel) {

        sb.append("{\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (seqOf == null) {
            sb.append("null");
        } else {
            Iterator<ERABParamsItem> it = seqOf.iterator();
            if (it.hasNext()) {
                it.next().appendAsString(sb, indentLevel + 1);
                while (it.hasNext()) {
                    sb.append(",\n");
                    for (int i = 0; i < indentLevel + 1; i++) {
                        sb.append("\t");
                    }
                    it.next().appendAsString(sb, indentLevel + 1);
                }
            }
        }

        sb.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            sb.append("\t");
        }
        sb.append("}");
    }

}

