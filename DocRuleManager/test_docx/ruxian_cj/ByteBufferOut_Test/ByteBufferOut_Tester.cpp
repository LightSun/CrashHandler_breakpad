#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class ByteBufferOut_Tester : public QObject
{ Q_OBJECT
public:
	ByteBufferOut_Tester();
	~ByteBufferOut_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_putByte_data();
	void testCase1_putByte();
	void testCase2_putInt_data();
	void testCase2_putInt();
	void testCase3_putShort_data();
	void testCase3_putShort();
	void testCase4_putLong_data();
	void testCase4_putLong();
	void testCase5_putBool_data();
	void testCase5_putBool();
	void testCase6_putFloat_data();
	void testCase6_putFloat();
	void testCase7_putDouble_data();
	void testCase7_putDouble();
	void testCase8_putUByte_data();
	void testCase8_putUByte();
	void testCase9_putUShort_data();
	void testCase9_putUShort();
	void testCase10_putUInt_data();
	void testCase10_putUInt();
	void testCase11_putULong_data();
	void testCase11_putULong();
	void testCase12_putData_data();
	void testCase12_putData();
	void testCase13_putRawString_data();
	void testCase13_putRawString();
	void testCase14_putString16_data();
	void testCase14_putString16();
	void testCase15_putString_data();
	void testCase15_putString();
	void testCase16_putString64_data();
	void testCase16_putString64();
	void testCase17_putListInt_data();
	void testCase17_putListInt();
	void testCase18_getLength_data();
	void testCase18_getLength();
	void testCase19_bufferToString_data();
	void testCase19_bufferToString();
	void testCase20_bufferToString_data();
	void testCase20_bufferToString();
	void testCase21_prepareBuffer_data();
	void testCase21_prepareBuffer();
	void testCase22_prepareBufferInc_data();
	void testCase22_prepareBufferInc();
	void testCase23_prepareBufferIncIfNeed_data();
	void testCase23_prepareBufferIncIfNeed();
	void testCase24_setBufferAutoInc_data();
	void testCase24_setBufferAutoInc();
	void testCase25_data_data();
	void testCase25_data();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
ByteBufferOut_Tester::ByteBufferOut_Tester()
{
}
ByteBufferOut_Tester::~ByteBufferOut_Tester()
{
}
void ByteBufferOut_Tester::initTestCase()
{
}
void ByteBufferOut_Tester::cleanupTestCase()
{
}
void ByteBufferOut_Tester::testCase1_putByte_data()
{
}
void ByteBufferOut_Tester::testCase1_putByte()
{
}
void ByteBufferOut_Tester::testCase2_putInt_data()
{
}
void ByteBufferOut_Tester::testCase2_putInt()
{
}
void ByteBufferOut_Tester::testCase3_putShort_data()
{
}
void ByteBufferOut_Tester::testCase3_putShort()
{
}
void ByteBufferOut_Tester::testCase4_putLong_data()
{
}
void ByteBufferOut_Tester::testCase4_putLong()
{
}
void ByteBufferOut_Tester::testCase5_putBool_data()
{
}
void ByteBufferOut_Tester::testCase5_putBool()
{
}
void ByteBufferOut_Tester::testCase6_putFloat_data()
{
}
void ByteBufferOut_Tester::testCase6_putFloat()
{
}
void ByteBufferOut_Tester::testCase7_putDouble_data()
{
}
void ByteBufferOut_Tester::testCase7_putDouble()
{
}
void ByteBufferOut_Tester::testCase8_putUByte_data()
{
}
void ByteBufferOut_Tester::testCase8_putUByte()
{
}
void ByteBufferOut_Tester::testCase9_putUShort_data()
{
}
void ByteBufferOut_Tester::testCase9_putUShort()
{
}
void ByteBufferOut_Tester::testCase10_putUInt_data()
{
}
void ByteBufferOut_Tester::testCase10_putUInt()
{
}
void ByteBufferOut_Tester::testCase11_putULong_data()
{
}
void ByteBufferOut_Tester::testCase11_putULong()
{
}
void ByteBufferOut_Tester::testCase12_putData_data()
{
}
void ByteBufferOut_Tester::testCase12_putData()
{
}
void ByteBufferOut_Tester::testCase13_putRawString_data()
{
}
void ByteBufferOut_Tester::testCase13_putRawString()
{
}
void ByteBufferOut_Tester::testCase14_putString16_data()
{
}
void ByteBufferOut_Tester::testCase14_putString16()
{
}
void ByteBufferOut_Tester::testCase15_putString_data()
{
}
void ByteBufferOut_Tester::testCase15_putString()
{
}
void ByteBufferOut_Tester::testCase16_putString64_data()
{
}
void ByteBufferOut_Tester::testCase16_putString64()
{
}
void ByteBufferOut_Tester::testCase17_putListInt_data()
{
}
void ByteBufferOut_Tester::testCase17_putListInt()
{
}
void ByteBufferOut_Tester::testCase18_getLength_data()
{
}
void ByteBufferOut_Tester::testCase18_getLength()
{
}
void ByteBufferOut_Tester::testCase19_bufferToString_data()
{
}
void ByteBufferOut_Tester::testCase19_bufferToString()
{
}
void ByteBufferOut_Tester::testCase20_bufferToString_data()
{
}
void ByteBufferOut_Tester::testCase20_bufferToString()
{
}
void ByteBufferOut_Tester::testCase21_prepareBuffer_data()
{
}
void ByteBufferOut_Tester::testCase21_prepareBuffer()
{
}
void ByteBufferOut_Tester::testCase22_prepareBufferInc_data()
{
}
void ByteBufferOut_Tester::testCase22_prepareBufferInc()
{
}
void ByteBufferOut_Tester::testCase23_prepareBufferIncIfNeed_data()
{
}
void ByteBufferOut_Tester::testCase23_prepareBufferIncIfNeed()
{
}
void ByteBufferOut_Tester::testCase24_setBufferAutoInc_data()
{
}
void ByteBufferOut_Tester::testCase24_setBufferAutoInc()
{
}
void ByteBufferOut_Tester::testCase25_data_data()
{
}
void ByteBufferOut_Tester::testCase25_data()
{
}
QTEST_MAIN(ByteBufferOut_Tester)
#include "ByteBufferOut_Tester.moc"
