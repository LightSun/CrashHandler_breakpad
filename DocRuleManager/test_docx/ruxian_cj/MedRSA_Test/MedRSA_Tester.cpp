#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class MedRSA_Tester : public QObject
{ Q_OBJECT
public:
	MedRSA_Tester();
	~MedRSA_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_setKeyIsPath_data();
	void testCase1_setKeyIsPath();
	void testCase2_encByPubKey_data();
	void testCase2_encByPubKey();
	void testCase3_encByPubKey_data();
	void testCase3_encByPubKey();
	void testCase4_decByPriKey_data();
	void testCase4_decByPriKey();
	void testCase5_decByPriKey_data();
	void testCase5_decByPriKey();
	void testCase6_decByPubKey_data();
	void testCase6_decByPubKey();
	void testCase7_decByPubKey_data();
	void testCase7_decByPubKey();
	void testCase8_encByPriKey_data();
	void testCase8_encByPriKey();
	void testCase9_encByPriKey_data();
	void testCase9_encByPriKey();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
MedRSA_Tester::MedRSA_Tester()
{
}
MedRSA_Tester::~MedRSA_Tester()
{
}
void MedRSA_Tester::initTestCase()
{
}
void MedRSA_Tester::cleanupTestCase()
{
}
void MedRSA_Tester::testCase1_setKeyIsPath_data()
{
}
void MedRSA_Tester::testCase1_setKeyIsPath()
{
}
void MedRSA_Tester::testCase2_encByPubKey_data()
{
}
void MedRSA_Tester::testCase2_encByPubKey()
{
}
void MedRSA_Tester::testCase3_encByPubKey_data()
{
}
void MedRSA_Tester::testCase3_encByPubKey()
{
}
void MedRSA_Tester::testCase4_decByPriKey_data()
{
}
void MedRSA_Tester::testCase4_decByPriKey()
{
}
void MedRSA_Tester::testCase5_decByPriKey_data()
{
}
void MedRSA_Tester::testCase5_decByPriKey()
{
}
void MedRSA_Tester::testCase6_decByPubKey_data()
{
}
void MedRSA_Tester::testCase6_decByPubKey()
{
}
void MedRSA_Tester::testCase7_decByPubKey_data()
{
}
void MedRSA_Tester::testCase7_decByPubKey()
{
}
void MedRSA_Tester::testCase8_encByPriKey_data()
{
}
void MedRSA_Tester::testCase8_encByPriKey()
{
}
void MedRSA_Tester::testCase9_encByPriKey_data()
{
}
void MedRSA_Tester::testCase9_encByPriKey()
{
}
QTEST_MAIN(MedRSA_Tester)
#include "MedRSA_Tester.moc"
