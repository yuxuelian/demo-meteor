package com.kaibo.demo.meteor.controller

import com.kaibo.demo.meteor.dto.BaseResult
import com.kaibo.demo.meteor.component.VerDiscern
import io.reactivex.Single
import lombok.extern.log4j.Log4j
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

/**
 * @author kaibo
 * @date 2019/9/17 13:29
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
@RequestMapping("/open/ver")
class VerDiscernController {

    @Autowired
    private lateinit var verDiscern: VerDiscern

    @PostMapping("/base64")
    fun base64VerDiscern(@RequestBody reqMap: Map<String, String?>): Single<BaseResult<String>> {
        val base64Data = reqMap["data"]
        return if (base64Data != null) {
            return verDiscern.base64ParseVer(base64Data).map {
                BaseResult.of(it)
            }
        } else {
            Single.just(BaseResult.of("data为必传参数"))
        }
    }

    @PostMapping("/file")
    fun fileVerDiscern(@RequestParam("file") file: MultipartFile): Single<BaseResult<String>> {
        return verDiscern.fileParseVer(file.bytes).map {
            BaseResult.of(it)
        }
    }

}
