## 堆栈回溯工具使用

### 目录
- jar 是bp使用工具jar。
- DocRuleManager 是bp使用工具源代码

### 编译breakpad
- 解压 SRC_breakpad_260811.zip
- 构建并安装： sh build.sh 
  
### 集成到项目
- 集成breakpad到主项目(app入口)
  ```
  #include "client/linux/handler/exception_handler.h"

  static bool dumpCallback(const google_breakpad::MinidumpDescriptor& descriptor,
  void* context, bool succeeded) {
    printf("Dump path: %s\n", descriptor.path());
    return succeeded;
  }

  int main(int argc, char* argv[]) {
    google_breakpad::MinidumpDescriptor descriptor("/tmp");
    google_breakpad::ExceptionHandler eh(descriptor, NULL, dumpCallback, NULL, true, -1);
    return 0;
  }
  ```
- 编译时 
  ```
  SET(CMAKE_CXX_FLAGS_RELEASE "${CMAKE_CXX_FLAGS_RELEASE} -g -O3")

  set(BREAK_PAD_DIR "/usr/local")
  set(BREAK_PAD_INC ${BREAK_PAD_DIR}/include/breakpad)
  set(BREAK_PAD_LIB ${BREAK_PAD_DIR}/lib/libbreakpad_client.a)
  
  target_include_directories(MedTJApiTest PUBLIC ${BREAK_PAD_INC})
  target_link_libraries(MedTJApiTest PUBLIC ${BREAK_PAD_LIB})
  ```

### 运行工具
- 支持gui模型和命令行模式

- gui模式
  ```
  java -jar libJGuiMain_BreakPad.jar --mode UI
  ```

- 命令行模式-符号生成
  ```
  java -jar libJGuiMain_BreakPad.jar --mode gen_symbol --workDir xxx --paths pathA,pathB,pathC
   //调用后会在$workDir/symbols 目录下生成。
  ```
- 命令行模式-strip
  ```
  java -jar libJGuiMain_BreakPad.jar --mode strip --workDir xxx --paths pathA,pathB,pathC
  //paths 多个路径用逗号分隔
  //调用后会将ELF文件（动态库和可执行程序）去除符号表，并生成到 $workDir/strip目录下
  ```
- 命令行模式-堆栈回溯
  ```
  java -jar libJGuiMain_BreakPad.jar --mode dump --workDir xxx --dump_file xxx.dmp
  //调用后会打印出堆栈
  ```
