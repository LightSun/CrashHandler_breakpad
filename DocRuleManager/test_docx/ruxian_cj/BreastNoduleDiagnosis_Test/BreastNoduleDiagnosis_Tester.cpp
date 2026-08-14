#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class BreastNoduleDiagnosis_Tester : public QObject
{ Q_OBJECT
public:
	BreastNoduleDiagnosis_Tester();
	~BreastNoduleDiagnosis_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_instance_data();
	void testCase1_instance();
	void testCase2_startDiag_data();
	void testCase2_startDiag();
	void testCase3_stopDiag_data();
	void testCase3_stopDiag();
	void testCase4_setHanged_data();
	void testCase4_setHanged();
	void testCase5_getHanged_data();
	void testCase5_getHanged();
	void testCase6_getHanged_data();
	void testCase6_getHanged();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
BreastNoduleDiagnosis_Tester::BreastNoduleDiagnosis_Tester()
{
}
BreastNoduleDiagnosis_Tester::~BreastNoduleDiagnosis_Tester()
{
}
void BreastNoduleDiagnosis_Tester::initTestCase()
{
}
void BreastNoduleDiagnosis_Tester::cleanupTestCase()
{
}
void BreastNoduleDiagnosis_Tester::testCase1_instance_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase1_instance()
{
}
void BreastNoduleDiagnosis_Tester::testCase2_startDiag_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase2_startDiag()
{
}
void BreastNoduleDiagnosis_Tester::testCase3_stopDiag_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase3_stopDiag()
{
}
void BreastNoduleDiagnosis_Tester::testCase4_setHanged_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase4_setHanged()
{
}
void BreastNoduleDiagnosis_Tester::testCase5_getHanged_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase5_getHanged()
{
}
void BreastNoduleDiagnosis_Tester::testCase6_getHanged_data()
{
}
void BreastNoduleDiagnosis_Tester::testCase6_getHanged()
{
}
QTEST_MAIN(BreastNoduleDiagnosis_Tester)
#include "BreastNoduleDiagnosis_Tester.moc"
