#include <QtTest>
#include <QCoreApplication>

using String = std::string;
class TrtInferEngine_Tester : public QObject
{ Q_OBJECT
public:
	TrtInferEngine_Tester();
	~TrtInferEngine_Tester();
private slots:
	void initTestCase();
	void cleanupTestCase();
	void testCase1_isEngineValid_data();
	void testCase1_isEngineValid();
	void testCase2_isEngineValid_data();
	void testCase2_isEngineValid();
	void testCase3_build_data();
	void testCase3_build();
	void testCase4_build_data();
	void testCase4_build();
	void testCase5_infer_data();
	void testCase5_infer();
	void testCase6_infer_data();
	void testCase6_infer();
	void testCase7_inferBatch_data();
	void testCase7_inferBatch();
	void testCase8_inferBatch_data();
	void testCase8_inferBatch();
	void testCase9_initEngine_data();
	void testCase9_initEngine();
	void testCase10_warmUp_data();
	void testCase10_warmUp();
	void testCase11_processDims_data();
	void testCase11_processDims();
	void testCase12_processDims_data();
	void testCase12_processDims();
	void testCase13_prepareExecuteContext_data();
	void testCase13_prepareExecuteContext();
	void testCase14_prepareExecuteContext_data();
	void testCase14_prepareExecuteContext();
	void testCase15_getOutputTensorCount_data();
	void testCase15_getOutputTensorCount();
	void testCase16_getOutputDims_data();
	void testCase16_getOutputDims();
	void testCase17_getOutputDims_data();
	void testCase17_getOutputDims();
private:
};
Q_DECLARE_METATYPE(String);
//-------- impl ---------
TrtInferEngine_Tester::TrtInferEngine_Tester()
{
}
TrtInferEngine_Tester::~TrtInferEngine_Tester()
{
}
void TrtInferEngine_Tester::initTestCase()
{
}
void TrtInferEngine_Tester::cleanupTestCase()
{
}
void TrtInferEngine_Tester::testCase1_isEngineValid_data()
{
}
void TrtInferEngine_Tester::testCase1_isEngineValid()
{
}
void TrtInferEngine_Tester::testCase2_isEngineValid_data()
{
}
void TrtInferEngine_Tester::testCase2_isEngineValid()
{
}
void TrtInferEngine_Tester::testCase3_build_data()
{
}
void TrtInferEngine_Tester::testCase3_build()
{
}
void TrtInferEngine_Tester::testCase4_build_data()
{
}
void TrtInferEngine_Tester::testCase4_build()
{
}
void TrtInferEngine_Tester::testCase5_infer_data()
{
}
void TrtInferEngine_Tester::testCase5_infer()
{
}
void TrtInferEngine_Tester::testCase6_infer_data()
{
}
void TrtInferEngine_Tester::testCase6_infer()
{
}
void TrtInferEngine_Tester::testCase7_inferBatch_data()
{
}
void TrtInferEngine_Tester::testCase7_inferBatch()
{
}
void TrtInferEngine_Tester::testCase8_inferBatch_data()
{
}
void TrtInferEngine_Tester::testCase8_inferBatch()
{
}
void TrtInferEngine_Tester::testCase9_initEngine_data()
{
}
void TrtInferEngine_Tester::testCase9_initEngine()
{
}
void TrtInferEngine_Tester::testCase10_warmUp_data()
{
}
void TrtInferEngine_Tester::testCase10_warmUp()
{
}
void TrtInferEngine_Tester::testCase11_processDims_data()
{
}
void TrtInferEngine_Tester::testCase11_processDims()
{
}
void TrtInferEngine_Tester::testCase12_processDims_data()
{
}
void TrtInferEngine_Tester::testCase12_processDims()
{
}
void TrtInferEngine_Tester::testCase13_prepareExecuteContext_data()
{
}
void TrtInferEngine_Tester::testCase13_prepareExecuteContext()
{
}
void TrtInferEngine_Tester::testCase14_prepareExecuteContext_data()
{
}
void TrtInferEngine_Tester::testCase14_prepareExecuteContext()
{
}
void TrtInferEngine_Tester::testCase15_getOutputTensorCount_data()
{
}
void TrtInferEngine_Tester::testCase15_getOutputTensorCount()
{
}
void TrtInferEngine_Tester::testCase16_getOutputDims_data()
{
}
void TrtInferEngine_Tester::testCase16_getOutputDims()
{
}
void TrtInferEngine_Tester::testCase17_getOutputDims_data()
{
}
void TrtInferEngine_Tester::testCase17_getOutputDims()
{
}
QTEST_MAIN(TrtInferEngine_Tester)
#include "TrtInferEngine_Tester.moc"
