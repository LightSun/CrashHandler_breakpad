#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class DataBlock_Tester : public QObject
{ Q_OBJECT
public:
	DataBlock_Tester();
	~DataBlock_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_setBlockCount_data();
	void testCase1_setBlockCount();
	void testCase2_isVerifyOk_data();
	void testCase2_isVerifyOk();
	void testCase3_isVerifyOk_data();
	void testCase3_isVerifyOk();
	void testCase4_getDecodeResult_data();
	void testCase4_getDecodeResult();
	void testCase5_getDecodeResult_data();
	void testCase5_getDecodeResult();
	void testCase6_setEncodeData_data();
	void testCase6_setEncodeData();
	void testCase7_setDecodeData_data();
	void testCase7_setDecodeData();
	void testCase8_setDecodeData_data();
	void testCase8_setDecodeData();
	void testCase9_toString_data();
	void testCase9_toString();
	void testCase10_fromString_data();
	void testCase10_fromString();
	void testCase11_fromString_data();
	void testCase11_fromString();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
DataBlock_Tester::DataBlock_Tester()
{
}
DataBlock_Tester::~DataBlock_Tester()
{
}
void DataBlock_Tester::initTestCase()
{
}
void DataBlock_Tester::cleanupTestCase()
{
}
void DataBlock_Tester::testCase1_setBlockCount_data()
{
}
void DataBlock_Tester::testCase1_setBlockCount()
{
}
void DataBlock_Tester::testCase2_isVerifyOk_data()
{
}
void DataBlock_Tester::testCase2_isVerifyOk()
{
}
void DataBlock_Tester::testCase3_isVerifyOk_data()
{
}
void DataBlock_Tester::testCase3_isVerifyOk()
{
}
void DataBlock_Tester::testCase4_getDecodeResult_data()
{
}
void DataBlock_Tester::testCase4_getDecodeResult()
{
}
void DataBlock_Tester::testCase5_getDecodeResult_data()
{
}
void DataBlock_Tester::testCase5_getDecodeResult()
{
}
void DataBlock_Tester::testCase6_setEncodeData_data()
{
}
void DataBlock_Tester::testCase6_setEncodeData()
{
}
void DataBlock_Tester::testCase7_setDecodeData_data()
{
}
void DataBlock_Tester::testCase7_setDecodeData()
{
}
void DataBlock_Tester::testCase8_setDecodeData_data()
{
}
void DataBlock_Tester::testCase8_setDecodeData()
{
}
void DataBlock_Tester::testCase9_toString_data()
{
}
void DataBlock_Tester::testCase9_toString()
{
}
void DataBlock_Tester::testCase10_fromString_data()
{
}
void DataBlock_Tester::testCase10_fromString()
{
}
void DataBlock_Tester::testCase11_fromString_data()
{
}
void DataBlock_Tester::testCase11_fromString()
{
}
QTEST_MAIN(DataBlock_Tester)
#include "DataBlock_Tester.moc"
