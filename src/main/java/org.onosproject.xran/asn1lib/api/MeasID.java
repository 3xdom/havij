/**
 * This class file was automatically generated by jASN1 v1.8.2 (http://www.openmuc.org)
 */

package org.onosproject.xran.asn1lib.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import org.onosproject.xran.asn1lib.ber.BerByteArrayOutputStream;
import org.onosproject.xran.asn1lib.ber.BerLength;
import org.onosproject.xran.asn1lib.ber.BerTag;
import org.onosproject.xran.asn1lib.ber.types.BerBoolean;
import org.onosproject.xran.asn1lib.ber.types.BerInteger;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MeasID implements Serializable {

    public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    public byte[] code = null;
    private BerInteger measobjectId = null;
    private BerInteger reportconfigId = null;
    private Action action = null;
    public MeasID() {
    }

    public MeasID(byte[] code) {
        this.code = code;
    }

    public BerInteger getMeasobjectId() {
        return measobjectId;
    }

    public void setMeasobjectId(BerInteger measobjectId) {
        this.measobjectId = measobjectId;
    }

    public BerInteger getReportconfigId() {
        return reportconfigId;
    }

    public void setReportconfigId(BerInteger reportconfigId) {
        this.reportconfigId = reportconfigId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
        int sublength;

        sublength = action.encode(os);
        codeLength += sublength;
        codeLength += BerLength.encodeLength(os, sublength);
        // write tag: CONTEXT_CLASS, CONSTRUCTED, 2
        os.write(0xA2);
        codeLength += 1;

        codeLength += reportconfigId.encode(os, false);
        // write tag: CONTEXT_CLASS, PRIMITIVE, 1
        os.write(0x81);
        codeLength += 1;

        codeLength += measobjectId.encode(os, false);
        // write tag: CONTEXT_CLASS, PRIMITIVE, 0
        os.write(0x80);
        codeLength += 1;

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
        BerTag berTag = new BerTag();

        if (withTag) {
            codeLength += tag.decodeAndCheck(is);
        }

        BerLength length = new BerLength();
        codeLength += length.decode(is);

        int totalLength = length.val;
        codeLength += totalLength;

        subCodeLength += berTag.decode(is);
        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
            measobjectId = new BerInteger();
            subCodeLength += measobjectId.decode(is, false);
            subCodeLength += berTag.decode(is);
        } else {
            throw new IOException("Tag does not match the mandatory sequence element tag.");
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
            reportconfigId = new BerInteger();
            subCodeLength += reportconfigId.decode(is, false);
            subCodeLength += berTag.decode(is);
        } else {
            throw new IOException("Tag does not match the mandatory sequence element tag.");
        }

        if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 2)) {
            subCodeLength += length.decode(is);
            action = new Action();
            subCodeLength += action.decode(is, null);
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
        StringBuilder sb = new StringBuilder();
        appendAsString(sb, 0);
        return sb.toString();
    }

    public void appendAsString(StringBuilder sb, int indentLevel) {

        sb.append("{");
        sb.append("\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (measobjectId != null) {
            sb.append("measobjectId: ").append(measobjectId);
        } else {
            sb.append("measobjectId: <empty-required-field>");
        }

        sb.append(",\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (reportconfigId != null) {
            sb.append("reportconfigId: ").append(reportconfigId);
        } else {
            sb.append("reportconfigId: <empty-required-field>");
        }

        sb.append(",\n");
        for (int i = 0; i < indentLevel + 1; i++) {
            sb.append("\t");
        }
        if (action != null) {
            sb.append("action: ");
            action.appendAsString(sb, indentLevel + 1);
        } else {
            sb.append("action: <empty-required-field>");
        }

        sb.append("\n");
        for (int i = 0; i < indentLevel; i++) {
            sb.append("\t");
        }
        sb.append("}");
    }

    public static class Action implements Serializable {

        private static final long serialVersionUID = 1L;

        @JsonIgnore
        public byte[] code = null;
        private Addmeasid addmeasid = null;
        private Delmeasid delmeasid = null;
        private BerBoolean hototarget = null;
        public Action() {
        }
        public Action(byte[] code) {
            this.code = code;
        }

        public Addmeasid getAddmeasid() {
            return addmeasid;
        }

        public void setAddmeasid(Addmeasid addmeasid) {
            this.addmeasid = addmeasid;
        }

        public Delmeasid getDelmeasid() {
            return delmeasid;
        }

        public void setDelmeasid(Delmeasid delmeasid) {
            this.delmeasid = delmeasid;
        }

        public BerBoolean getHototarget() {
            return hototarget;
        }

        public void setHototarget(BerBoolean hototarget) {
            this.hototarget = hototarget;
        }

        public int encode(BerByteArrayOutputStream os) throws IOException {

            if (code != null) {
                for (int i = code.length - 1; i >= 0; i--) {
                    os.write(code[i]);
                }
                return code.length;
            }

            int codeLength = 0;
            if (hototarget != null) {
                codeLength += hototarget.encode(os, false);
                // write tag: CONTEXT_CLASS, PRIMITIVE, 2
                os.write(0x82);
                codeLength += 1;
                return codeLength;
            }

            if (delmeasid != null) {
                codeLength += delmeasid.encode(os, false);
                // write tag: CONTEXT_CLASS, CONSTRUCTED, 1
                os.write(0xA1);
                codeLength += 1;
                return codeLength;
            }

            if (addmeasid != null) {
                codeLength += addmeasid.encode(os, false);
                // write tag: CONTEXT_CLASS, CONSTRUCTED, 0
                os.write(0xA0);
                codeLength += 1;
                return codeLength;
            }

            throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
        }

        public int decode(InputStream is) throws IOException {
            return decode(is, null);
        }

        public int decode(InputStream is, BerTag berTag) throws IOException {

            int codeLength = 0;
            BerTag passedTag = berTag;

            if (berTag == null) {
                berTag = new BerTag();
                codeLength += berTag.decode(is);
            }

            if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
                addmeasid = new Addmeasid();
                codeLength += addmeasid.decode(is, false);
                return codeLength;
            }

            if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
                delmeasid = new Delmeasid();
                codeLength += delmeasid.decode(is, false);
                return codeLength;
            }

            if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
                hototarget = new BerBoolean();
                codeLength += hototarget.decode(is, false);
                return codeLength;
            }

            if (passedTag != null) {
                return 0;
            }

            throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
        }

        public void encodeAndSave(int encodingSizeGuess) throws IOException {
            BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
            encode(os);
            code = os.getArray();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            appendAsString(sb, 0);
            return sb.toString();
        }

        public void appendAsString(StringBuilder sb, int indentLevel) {

            if (addmeasid != null) {
                sb.append("addmeasid: ");
                addmeasid.appendAsString(sb, indentLevel + 1);
                return;
            }

            if (delmeasid != null) {
                sb.append("delmeasid: ");
                delmeasid.appendAsString(sb, indentLevel + 1);
                return;
            }

            if (hototarget != null) {
                sb.append("hototarget: ").append(hototarget);
                return;
            }

            sb.append("<none>");
        }

        public static class Addmeasid implements Serializable {

            public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
            private static final long serialVersionUID = 1L;
            @JsonIgnore
            public byte[] code = null;
            private List<BerInteger> seqOf = null;

            public Addmeasid() {
                seqOf = new ArrayList<BerInteger>();
            }

            public Addmeasid(byte[] code) {
                this.code = code;
            }

            @JsonValue
            public List<BerInteger> getBerInteger() {
                if (seqOf == null) {
                    seqOf = new ArrayList<BerInteger>();
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
                    BerInteger element = new BerInteger();
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
                    Iterator<BerInteger> it = seqOf.iterator();
                    if (it.hasNext()) {
                        sb.append(it.next());
                        while (it.hasNext()) {
                            sb.append(",\n");
                            for (int i = 0; i < indentLevel + 1; i++) {
                                sb.append("\t");
                            }
                            sb.append(it.next());
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

        public static class Delmeasid implements Serializable {

            public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);
            private static final long serialVersionUID = 1L;
            @JsonIgnore
            public byte[] code = null;
            private List<BerInteger> seqOf = null;

            public Delmeasid() {
                seqOf = new ArrayList<BerInteger>();
            }

            public Delmeasid(byte[] code) {
                this.code = code;
            }

            @JsonValue
            public List<BerInteger> getBerInteger() {
                if (seqOf == null) {
                    seqOf = new ArrayList<BerInteger>();
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
                    BerInteger element = new BerInteger();
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
                    Iterator<BerInteger> it = seqOf.iterator();
                    if (it.hasNext()) {
                        sb.append(it.next());
                        while (it.hasNext()) {
                            sb.append(",\n");
                            for (int i = 0; i < indentLevel + 1; i++) {
                                sb.append("\t");
                            }
                            sb.append(it.next());
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

    }

}
