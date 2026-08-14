#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class AES_Tester : public QObject
{ Q_OBJECT
public:
	AES_Tester();
	~AES_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_getMaxThreadCount_data();
	void testCase1_getMaxThreadCount();
	void testCase2_cfb128_data();
	void testCase2_cfb128();
	void testCase3_cfb128_data();
	void testCase3_cfb128();
	void testCase4_cfb128_data();
	void testCase4_cfb128();
	void testCase5_cfb128_data();
	void testCase5_cfb128();
	void testCase6_ofb128_data();
	void testCase6_ofb128();
	void testCase7_ofb128_data();
	void testCase7_ofb128();
	void testCase8_ofb128_data();
	void testCase8_ofb128();
	void testCase9_ofb128_data();
	void testCase9_ofb128();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
AES_Tester::AES_Tester()
{
}
AES_Tester::~AES_Tester()
{
}
void AES_Tester::initTestCase()
{
}
void AES_Tester::cleanupTestCase()
{
}
void AES_Tester::testCase1_getMaxThreadCount_data()
{
}
void AES_Tester::testCase1_getMaxThreadCount()
{
}
void AES_Tester::testCase2_cfb128_data()
{
}
void AES_Tester::testCase2_cfb128()
{
}
void AES_Tester::testCase3_cfb128_data()
{
}
void AES_Tester::testCase3_cfb128()
{
}
void AES_Tester::testCase4_cfb128_data()
{
}
void AES_Tester::testCase4_cfb128()
{
}
void AES_Tester::testCase5_cfb128_data()
{
}
void AES_Tester::testCase5_cfb128()
{
}
void AES_Tester::testCase6_ofb128_data()
{
}
void AES_Tester::testCase6_ofb128()
{
}
void AES_Tester::testCase7_ofb128_data()
{
}
void AES_Tester::testCase7_ofb128()
{
}
void AES_Tester::testCase8_ofb128_data()
{
}
void AES_Tester::testCase8_ofb128()
{
}
void AES_Tester::testCase9_ofb128_data()
{
}
void AES_Tester::testCase9_ofb128()
{
}
QTEST_MAIN(AES_Tester)
#include "AES_Tester.moc"
