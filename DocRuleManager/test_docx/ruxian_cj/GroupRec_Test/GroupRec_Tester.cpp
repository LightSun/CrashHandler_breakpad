#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class GroupRec_Tester : public QObject
{ Q_OBJECT
public:
	GroupRec_Tester();
	~GroupRec_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_inferBatch_data();
	void testCase1_inferBatch();
	void testCase2_mockInferAndSum_data();
	void testCase2_mockInferAndSum();
	void testCase3_sum_data();
	void testCase3_sum();
	void testCase4_avg_data();
	void testCase4_avg();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
GroupRec_Tester::GroupRec_Tester()
{
}
GroupRec_Tester::~GroupRec_Tester()
{
}
void GroupRec_Tester::initTestCase()
{
}
void GroupRec_Tester::cleanupTestCase()
{
}
void GroupRec_Tester::testCase1_inferBatch_data()
{
}
void GroupRec_Tester::testCase1_inferBatch()
{
}
void GroupRec_Tester::testCase2_mockInferAndSum_data()
{
}
void GroupRec_Tester::testCase2_mockInferAndSum()
{
}
void GroupRec_Tester::testCase3_sum_data()
{
}
void GroupRec_Tester::testCase3_sum()
{
}
void GroupRec_Tester::testCase4_avg_data()
{
}
void GroupRec_Tester::testCase4_avg()
{
}
QTEST_MAIN(GroupRec_Tester)
#include "GroupRec_Tester.moc"
