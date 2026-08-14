#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class ThreadPool_Tester : public QObject
{ Q_OBJECT
public:
	ThreadPool_Tester();
	~ThreadPool_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_isStoped_data();
	void testCase1_isStoped();
	void testCase2_isStoped_data();
	void testCase2_isStoped();
	void testCase3_stop_data();
	void testCase3_stop();
	void testCase4_enqueue_data();
	void testCase4_enqueue();
	void testCase5_batchRawRun_data();
	void testCase5_batchRawRun();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
ThreadPool_Tester::ThreadPool_Tester()
{
}
ThreadPool_Tester::~ThreadPool_Tester()
{
}
void ThreadPool_Tester::initTestCase()
{
}
void ThreadPool_Tester::cleanupTestCase()
{
}
void ThreadPool_Tester::testCase1_isStoped_data()
{
}
void ThreadPool_Tester::testCase1_isStoped()
{
}
void ThreadPool_Tester::testCase2_isStoped_data()
{
}
void ThreadPool_Tester::testCase2_isStoped()
{
}
void ThreadPool_Tester::testCase3_stop_data()
{
}
void ThreadPool_Tester::testCase3_stop()
{
}
void ThreadPool_Tester::testCase4_enqueue_data()
{
}
void ThreadPool_Tester::testCase4_enqueue()
{
}
void ThreadPool_Tester::testCase5_batchRawRun_data()
{
}
void ThreadPool_Tester::testCase5_batchRawRun()
{
}
QTEST_MAIN(ThreadPool_Tester)
#include "ThreadPool_Tester.moc"
